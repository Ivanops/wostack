package your.app.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import your.app.*;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSData;

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
	public NSData img;
	public String imgName;
	private int count;

	public Create(WOContext context) {
        super(context);
        this.nameToInsert = "";
        this.contentToInsert = "";
        
        this.lastTitle = "";
        this.lastContent = "";
        
        questions = Helper.getQuestions();
        this.img = new NSData();
        this.imgName = "";
        this.count = 0;
    }
	
	public void checkClick () {
		if(this.nameToInsert != null && this.contentToInsert != null) {
			Question question = new Question(this.nameToInsert, this.contentToInsert);

			try {
				if(this.imgName != "") {
					File f2 = new File("../../Resources/images/" + this.imgName);
					FileOutputStream fos2 = new FileOutputStream(f2.getAbsolutePath());
					img.writeToStream(fos2);				
					fos2.close();
					
					File f = new File("Contents/Resources/images/" + this.imgName);
					FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
					img.writeToStream(fos);				
					fos.close();
										
					question.setImagePath("images/" + f.getName());
				}

				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Helper.addQuestions(question);			
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