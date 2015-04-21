package your.app;

import java.util.ArrayList;

/**
 * Class Helper that handle the Questions
 *
 */
public class Helper {
	
	private static ArrayList<Question> Questions = new ArrayList<Question>();
	private static Question SelectedQuestions;

	/**
	 * Gets the question list
	 * @return ArrayList<Question>
	 */
	public static ArrayList<Question> getQuestions() {
		return Questions;
	}

	/**
	 * Adds a new question to the question list
	 * @param question
	 */
	public static void addQuestions(Question question) {
		Questions.add(question);
	}

	/**
	 * Gets the question that was selected
	 * @return Question
	 */
	public static Question getSelectedQuestions() {
		return SelectedQuestions;
	}

	
	/**
	 * Sets the selected question
	 * @param selectedQuestions
	 */
	public static void setSelectedQuestions(Question selectedQuestions) {
		SelectedQuestions = selectedQuestions;
	}
	
	/**
	 * Gets a Question from an Id
	 * @param questionId
	 * @return a Question if it found or null if not
	 */
	public static Question getQuestionsById(int questionId) {
		for (Question question : Questions) {
			if(question.getId() == questionId){
				return question;
			}
		}
		return null;
	}
	
	/**
	 * Sets a Question from an Id
	 * @param questionId
	 */
	public static void setSelectedQuestionsById(int questionId) {
		Question question = getQuestionsById(questionId);
		if(question != null){
			SelectedQuestions = question;
		}
		
	}
}
