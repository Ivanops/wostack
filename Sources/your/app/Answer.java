package your.app;

public class Answer {
	
	private int points;
	private String content;
	private String person;
	
	public Answer(String content, String person) {
		this.setContent(content);
		this.setPerson(person);
		this.setPoints(0);
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
}
