package your.app;

import com.webobjects.foundation.NSData;

/**
 * @author Ivan
 *
 */
public class Answer {
	
	private int points;
	private String content;
	private String person;
	public NSData img;
	public String imagePath;
	
	
	/**
	 * Constructor
	 */
	public Answer(){
		
	}
	
	/**
	 * Constructor
	 * @param content
	 * @param person
	 */
	public Answer(String content, String person) {
		this.setContent(content);
		this.setPerson(person);
		this.setPoints(0);
		this.setImagePath("");
		this.img = new NSData();
	}
	
	/**
	 * Gets the points of the answer
	 * @return points of Answer
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets points to the answer
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Gets the person who wrote the answer
	 * @return person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * Sets the person name to the answer
	 * @param person
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	
	/**
	 * Gets the answers's content
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the answers's content
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Sets the answers's image path
	 * @param newPath
	 */
	public void setImagePath(String newPath) {
		this.imagePath = newPath;
	}
	
	/**
	 * Gets the image path
	 * @return image path
	 */
	public String getImagePath(){
		return this.imagePath;
	}
	
	/**
	 * Sets the image
	 * @param img
	 */
	public void setImage(NSData img){
		this.img = img;
	}
	
	/**
	 * Gets the image
	 * @return image
	 */
	public NSData getImage(){
		return this.img;
	}
	
	/**
	 * Checks if answers has an image
	 * @return true is it does and false if not
	 */
	public boolean hasAnswerImage(){
		return this.imagePath != "" ? true:false;
	}
}
