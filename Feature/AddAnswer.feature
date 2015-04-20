Feature: Add answer to a Question
 
Scenario: Successful Add an answer
	Given User create question one
	Then User select question one
	Then User add an answer
	Then The answer is shown in the page
	Then Close Browser
	 