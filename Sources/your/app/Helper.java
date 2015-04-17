package your.app;

import java.util.ArrayList;

public class Helper {
	private static ArrayList<Question> Questions = new ArrayList<Question>();
	private static Question SelectedQuestions;

	public static ArrayList<Question> getQuestions() {
		return Questions;
	}

	public static void addQuestions(Question question) {
		Questions.add(question);
	}

	public static Question getSelectedQuestions() {
		return SelectedQuestions;
	}

	public static void setSelectedQuestions(Question selectedQuestions) {
		SelectedQuestions = selectedQuestions;
	}
	
	public static void addAnswerToQuestions(Answer answer) {
		SelectedQuestions.addAnswer(answer);
	}

	public static Question getQuestionsById(int questionId) {
		for (Question question : Questions) {
			if(question.getId() == questionId){
				return question;
			}
		}
		return null;
	}
	
	public static void setSelectedQuestionsById(int questionId) {
		Question question = getQuestionsById(questionId);
		if(question != null){
			SelectedQuestions = question;
		}
		
	}
}
