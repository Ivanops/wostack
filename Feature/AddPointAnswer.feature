Feature: Add Point to Answer
 
Scenario: Successful add a point to an Answer
	Given User is on Home Page
	And User enters Title and Content
	And User click on question title
	And User add Answer
	And User add Point to Answer
	Then Exit Browser
	
