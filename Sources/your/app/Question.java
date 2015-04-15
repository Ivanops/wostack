package your.app;

public class Question {
	
	private String title;
	private String content;
	
	public Question(String title, String content) {
		this.setTitle(title);
		this.setContent(content);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
