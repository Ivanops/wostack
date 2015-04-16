package your.app.components;

import java.util.ArrayList;

import your.app.Question;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class QuestionView extends WOComponent {
	
	private Question question;
	private  ArrayList Answers;
	public String answer;
	public String newAnswer;
    
    public QuestionView(WOContext context) {
        super(context);
        String title = "Is it correct do this?";
        String content = "I have problem with this...";
        question = new Question(title, content);
        
        question.addAnswer("This should be this...");
        question.addAnswer("Your problem is that you are.....");
        question.addAnswer("Problably you need....");
        question.addAnswer("Let me know if you can.....");
        
    }

    public String getTitle() {
        return question.getTitle();
    }

    public String getContent() {
        return question.getContent();
    }

    public ArrayList getList() {
		return question.getAnswers();
	} 
    
    public void addAnswer () {
    	System.out.println(this.newAnswer);
		question.addAnswer(this.newAnswer);
		this.newAnswer = "";
	}
}