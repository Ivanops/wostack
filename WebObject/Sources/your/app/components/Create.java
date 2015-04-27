package your.app.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import your.app.Question;

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

	/** Constructor WebObjectComponent
	 * @param context
	 */
	public Create(WOContext context) {
        super(context);
        this.nameToInsert = "";
        this.contentToInsert = "";
        
        this.lastTitle = "";
        this.lastContent = "";
        
        questions = (ArrayList<Question>)this.application().valueForKey("questions");
        this.img = new NSData();
        this.imgName = "";
        this.count = 0;
    }
	
	/**
	 * Creates a new question
	 */
	public void checkClick () {
		if(this.nameToInsert != null && this.contentToInsert != null) {
			Question question = new Question(this.nameToInsert, this.contentToInsert);

			try {
				if(this.imgName != "") {	
					
					String destinationFolderName = "c:\\images\\stackoverflow\\resources\\";
					File destinationFolder = new File(destinationFolderName);
					
					if(!destinationFolder.exists()){
						destinationFolder.mkdirs();
					}
					String imageDestination = destinationFolderName + this.imgName;
					File imageToSave = new File(imageDestination);
					FileOutputStream streamToImage = new FileOutputStream(imageToSave.getCanonicalPath());
					img.writeToStream(streamToImage);				
					streamToImage.close();
										
					question.setImagePath("/stackoverflow/resources/" + this.imgName);
				}

				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			questions.add(question);			
			this.lastTitle = this.nameToInsert;
			this.lastContent = this.contentToInsert;
						
		} else {
			this.lastTitle = "Your Title or Content input has an error";
			this.lastContent = "";
		}
		 
		this.nameToInsert = "";
        this.contentToInsert = "";
	}
}