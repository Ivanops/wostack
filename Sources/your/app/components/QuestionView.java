package your.app.components;

import java.util.ArrayList;

import your.app.Answer;
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
	public String person = "Anonymous";
	public String answerImageName;
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
    }
   
    /**
     * Sets the Question
     * @param Questio
     */
    public void setQuestion(Question questionItem) {
        question = questionItem;
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
    		if(this.answerImageName != "") {
				try {
					String destinationFolderName = "c:\\images\\stackoverflow\\resources\\answers\\";
					File destinationFolder = new File(destinationFolderName);
					
					if(!destinationFolder.exists()){
						destinationFolder.mkdirs();
					}
					String imageDestination = destinationFolderName + this.answerImageName;
					File imageToSave = new File(imageDestination);
					FileOutputStream streamToImage = new FileOutputStream(imageToSave.getCanonicalPath());
					answerImage.writeToStream(streamToImage);				
					streamToImage.close();
										
					ans.imagePath = "/stackoverflow/resources/answers/" + this.answerImageName;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}    		
    		}
    		question.addAnswer(ans);
    		error = "";
    		this.newAnswer = "";
    		this.answerImageName = "";
    	}else{
    		error = "Your Answer field or Person field are empty.";
    	}
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