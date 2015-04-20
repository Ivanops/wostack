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
    
    public QuestionView(WOContext context) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super(context);
        this.answerImagePath = "";
        this.answerImage = new NSData();
        WOComponent QuestionItem =  context.component();
        Method getId = QuestionItem.getClass().getMethod("getId");
        int Id = (Integer)getId.invoke(QuestionItem);
        question = Helper.getQuestionsById(Id);
    }

    public String getTitle() {
        return question.getTitle();
    }

    public String getContent() {
        return question.getContent();
    }
    
    public String getImagePath() {
    	return question.getImagePath();
    }

    public boolean hasImage(){
    	return question.getImagePath() != null ? true:false;
    }
    
    public ArrayList<Answer> getList() {
		return question.getAnswers();
	} 
    
    public void addAnswer () {
    	if(!this.newAnswer.equals("") && !this.person.equals("")) {
    		Answer ans = new Answer(this.newAnswer, this.person);
    		System.out.println(this.answerImagePath);
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
    	}
		this.newAnswer = "";
		this.person = "";
		this.answerImagePath = "";
	}
    
    public void addPoint () {
    	System.out.println(this.index);
    	System.out.println("ADD");
    	Answer aux = question.getAnswers().get(index);
    	aux.setPoints(aux.getPoints() + 1);
    }
    
    public void removePoint () {
    	System.out.println(this.index);
    	System.out.println("remove");
    	Answer aux = question.getAnswers().get(index);
    	aux.setPoints(aux.getPoints() - 1);
    }
}