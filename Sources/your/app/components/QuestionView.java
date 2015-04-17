package your.app.components;
import your.app.*;

import java.util.ArrayList;

import your.app.Question;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class QuestionView extends WOComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question;
	public Answer answer;
	public String newAnswer;
	public Integer index;
	public String person = "unknow";
    
    public QuestionView(WOContext context) {
        super(context);
        String title = "Is it correct do this?";
        String content = "I have problem with this...";
        question = new Question(title, content);
        
    }

    public String getTitle() {
        return question.getTitle();
    }

    public String getContent() {
        return question.getContent();
    }

    public ArrayList<Answer> getList() {
		return question.getAnswers();
	} 
    
    public void addAnswer () {
    	Answer aux = new Answer(this.newAnswer, this.person);
		question.addAnswer(aux);
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