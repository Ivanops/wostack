Feature: Create Question
 
Scenario: Successful create a question
	Given User is on Home Page
	And User enters Title and Content
	Then Title and Content show
	Then Exit Browser
	
