package your.app;

import com.webobjects.foundation.NSData;

public class Answer {
	
	private int points;
	private String content;
	private String person;
	public NSData img;
	public String imagePath;
	
	public Answer(){
		
	}
	public Answer(String content, String person) {
		this.setContent(content);
		this.setPerson(person);
		this.setPoints(0);
		this.setImagePath("");
		this.img = new NSData();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setImagePath(String newPath) {
		this.imagePath = newPath;
	}
	
	public String getImagePath(){
		return this.imagePath;
	}
	
	public void setImage(NSData img){
		this.img = img;
	}
	
	public NSData getImage(){
		return this.img;
	}
	
	public boolean hasAnswerImage(){
		return this.imagePath != "" ? true:false;
	}
}
