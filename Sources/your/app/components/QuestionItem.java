package your.app.components;

import your.app.Helper;
import your.app.Session;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WORedirect;

public class QuestionItem extends WOComponent {
	private static final long serialVersionUID = 1L;
	public int questionId;
	public String questionTitle;
	public String questionContent;
	
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