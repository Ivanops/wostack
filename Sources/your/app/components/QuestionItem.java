package your.app.components;

import your.app.Helper;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class QuestionItem extends WOComponent {
	private static final long serialVersionUID = 1L;
	public int questionId;
	public String questionTitle;
	public String questionContent;
	public String questionImagePath;
	
    public QuestionItem(WOContext context) {
        super(context);
    }
    
    public void selectQuestion(){
    	Helper.setSelectedQuestionsById(this.questionId);
    }
    
    public int getId() {
    	return this.questionId;
    }
}