Feature: Add answer to a Question
 
Scenario: Successful Add an answer
	Given User create question: "I have this question?", with content: "Is it correct do this.;" 
	Then User select question "I have this question?"
	Then User "Pepito" add the answer: "You should remove that semicolon"
	Then The answer "You should remove that semicolon" of "Pepito" is shown in the page
	Then Close Browser
	
	
Scenario: Not add an answer when inputs are empty
	Given User create question: "I have this other question?", with content: "Maybe i am doing something wrong."
	Then User select question "I have this other question?"
	Then User try to add an empty answer
	Then No answer is shown in the page
	Then Close Browser
	 