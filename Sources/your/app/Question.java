package your.app;

import java.util.ArrayList;
import java.util.Iterator;

public class Question {
	
	private String title;
	private String content;
	private ArrayList<Answer> Answers;
	
	public Question(String title, String content) {
		this.setTitle(title);
		this.setContent(content);
		this.Answers = new ArrayList<Answer>();
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
	
	public ArrayList<Answer> getAnswers() {
		return Answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		Answers = answers;
	}
	
	public void addAnswer(Answer answer) {
		this.Answers.add(answer);
		this.showAnswers();
	}
	
	public void showAnswers() {
		for (Answer item : this.Answers) {
			System.out.println(item.getContent());
			System.out.println(item.getPoints());
			System.out.println(item.getPerson());
		}
			
	}
}
