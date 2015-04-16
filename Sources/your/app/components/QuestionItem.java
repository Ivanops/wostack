package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class QuestionItem extends WOComponent {
	private static final long serialVersionUID = 1L;
	public String questionTitle;
	public String questionContent;
	
    public QuestionItem(WOContext context) {
        super(context);
    }
}