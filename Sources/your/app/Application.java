// Generated by the WOLips Templateengine Plug-in at Apr 14, 2015 4:13:55 PM
package your.app;

import java.util.ArrayList;

import com.webobjects.foundation.NSLog;

import com.webobjects.appserver.WOApplication;

public class Application extends WOApplication {
	public static void main(String[] argv) {
		WOApplication.main(argv, Application.class);
	}
	
	public ArrayList<Question> questions;

	public Application() {
		NSLog.out.appendln("Welcome to " + name() + "!");
		this.setQuestions(new ArrayList<Question>());
		setAllowsConcurrentRequestHandling(true);
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
}
