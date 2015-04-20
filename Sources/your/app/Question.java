package your.app;

import java.util.ArrayList;
import java.util.Iterator;

import cucumber.api.java.lu.an;

public class Question {
	
	private int Id;
	private String title;
	private String content;
	private ArrayList<Answer> Answers;
	private String imagePath;
	
	public Question(String title, String content) {
		Double d = Math.random()*1000000;
		this.Id = d.intValue();
		this.setTitle(title);
		this.setContent(content);
		this.Answers = new ArrayList<Answer>();
	}

	public int getId() {
		return this.Id;
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
	
	public void setImagePath(String path) {
		this.imagePath = path;
	}
	
	public String getImagePath(){
		return this.imagePath;
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
