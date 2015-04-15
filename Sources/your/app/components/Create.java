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
	
	private Question questions[];
	private int count;

	public Create(WOContext context) {
        super(context);
        this.nameToInsert = "";
        this.contentToInsert = "";
        this.questions = new Question[10];
        this.count = 0;
    }
	
	public void checkClick () {
		System.out.println(this.nameToInsert);
		System.out.println(this.contentToInsert);
		Question question = new Question(this.nameToInsert, this.contentToInsert);
		this.questions[this.count++] = question;
		this.showQuestions();
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