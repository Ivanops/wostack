package your.app.components;

import your.app.Question;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class QuestionItem extends WOComponent {
	private static final long serialVersionUID = 1L;
	public Question question;
	
    public QuestionItem(WOContext context) {
        super(context);
    }
    
    public WOComponent showQuestion(){
    	
    	QuestionView questionView = (QuestionView)pageWithName("QuestionView");
    	questionView.setQuestion(question);
        return questionView;
    }
}