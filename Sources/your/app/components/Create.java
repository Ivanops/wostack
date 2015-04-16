package your.app.components;

import your.app.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class Create extends WOComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String nameToInsert;
	public String contentToInsert;
	
	public String lastTitle;
	public String lastContent;
	
	private Question questions[];
	private int count;

	public Create(WOContext context) {
        super(context);
        this.nameToInsert = "";
        this.contentToInsert = "";
        
        this.lastTitle = "";
        this.lastContent = "";
        
        this.questions = new Question[10];
        this.count = 0;
    }
	
	public void checkClick () {
		if(this.nameToInsert != null && this.contentToInsert != null) {
			Question question = new Question(this.nameToInsert, this.contentToInsert);
			this.questions[this.count++] = question;
			this.showQuestions();
			this.lastTitle = this.nameToInsert;
			this.lastContent = this.contentToInsert;
			
			
		} else {
			this.lastTitle = "Your Title or Content input has an error";
			this.lastContent = "";
		}
		 
		this.nameToInsert = "";
        this.contentToInsert = "";
		
	}
	
	public void showQuestions() {
		for (int i = 0; i < this.count; i++) {
			System.out.println("Question: " + i);
			System.out.println(this.questions[i].getTitle());
			System.out.println(this.questions[i].getContent());
		}
	}

}