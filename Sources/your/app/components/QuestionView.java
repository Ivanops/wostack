package your.app.components;

import java.util.ArrayList;

import your.app.Answer;
import your.app.Helper;
import your.app.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSData;

public class QuestionView extends WOComponent {
	
	private static final long serialVersionUID = 1L;
	private Question question;
	public Answer answer;
	public String newAnswer;
	public Integer index;
	public String person = "unknow";
	public String answerImagePath;
	public NSData answerImage;
	public String error;
    
    /**
     * Component to show the Question view
     * @param context
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public QuestionView(WOContext context) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super(context);
        this.answerImagePath = "";
        this.answerImage = new NSData();
        
        //Obtain the question Id from context(Dynamic object)
        WOComponent QuestionItem =  context.component();
        Method getId = QuestionItem.getClass().getMethod("getId");
        int Id = (Integer)getId.invoke(QuestionItem);
        question = Helper.getQuestionsById(Id);
    }

    /**
     * Gets the title
     * @return Title
     */
    public String getTitle() {
        return question.getTitle();
    }

    /**
     * Gets the content
     * @return Content
     */
    public String getContent() {
        return question.getContent();
    }
    
    /**
     * Gets the ImagePath 
     * @return ImagePath
     */
    public String getImagePath() {
    	return question.getImagePath();
    }

    /**
     * Verify if has Image 
     * @return boolean
     */
    public boolean hasImage(){
    	return question.getImagePath() != null ? true:false;
    }
    
    /**
     * Gets the List of questions.
     * @return QuestionList
     */
    public ArrayList<Answer> getList() {
		return question.getAnswers();
	} 
    
    /**
     * Adds and Answer to a specific question
     */
    public void addAnswer () {
    	if(this.newAnswer != null && this.person != null) {
    		Answer ans = new Answer(this.newAnswer, this.person);
    		if(this.answerImagePath != "") {
				try {
					ans.imagePath = "images/" + this.answerImagePath;
					
					File f = new File("Contents/Resources/images/" + this.answerImagePath);
					FileOutputStream fos;
					fos = new FileOutputStream(f.getAbsolutePath());
					this.answerImage.writeToStream(fos);				
					fos.close();
					
					File f2 = new File("../../Resources/images/" + this.answerImagePath);
					FileOutputStream fos2;
					fos2 = new FileOutputStream(f2.getAbsolutePath());
					this.answerImage.writeToStream(fos2);				
					fos2.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}    		
    		}
    		question.addAnswer(ans);
    		error = "";
    	}else{
    		error = "The User field or Answer field are empty.";
    	}
		this.newAnswer = "";
		this.answerImagePath = "";
	}
    
    /**
     * Gives a point to the answer
     */
    public void addPoint () {
    	System.out.println(this.index);
    	System.out.println("ADD");
    	Answer aux = question.getAnswers().get(index);
    	aux.setPoints(aux.getPoints() + 1);
    }
    
    /**
     * Remove the Point the answer
     */
    public void removePoint () {
    	System.out.println(this.index);
    	System.out.println("remove");
    	Answer aux = question.getAnswers().get(index);
    	aux.setPoints(aux.getPoints() - 1);
    }
}