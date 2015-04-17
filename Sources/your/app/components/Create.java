package your.app.components;

import java.util.ArrayList;

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
	
	/*public Question questions[];*/
	public ArrayList<Question> questions;
	public Question currentQuestion;
	private int count;

	public Create(WOContext context) {
        super(context);
        this.nameToInsert = "";
        this.contentToInsert = "";
        
        this.lastTitle = "";
        this.lastContent = "";
        
        questions = Helper.getQuestions();
        this.count = 0;
    }
	
	public void checkClick () {
		if(this.nameToInsert != null && this.contentToInsert != null) {
			Question question = new Question(this.nameToInsert, this.contentToInsert);
			Helper.addQuestions(question);
			this.questions.add(question);
			this.count++;
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
		System.out.println("show!!!");
		for (int i = 0; i < this.count; i++) {
			System.out.println("Question: " + (i+1));
			System.out.println(this.questions.get(i).getTitle());
			System.out.println(this.questions.get(i).getContent());
		}
	}

}