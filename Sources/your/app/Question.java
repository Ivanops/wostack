package your.app;

import java.util.ArrayList;

public class Question {
	
	private String title;
	private String content;
	private ArrayList Answers;
	
	public Question(String title, String content) {
		this.setTitle(title);
		this.setContent(content);
		this.Answers = new ArrayList();
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
	
	public ArrayList getAnswers() {
		return Answers;
	}

	public void setAnswers(ArrayList answers) {
		Answers = answers;
	}
	
	public void addAnswer(String answer) {
		this.Answers.add(answer);

	}
}
