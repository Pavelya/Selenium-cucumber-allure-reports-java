@search
Feature: Search 
	As a user I should able to see and use search
 
Scenario: Search 
	Given  I print configuration 
	And I navigate to https://declarator.org/
	Then my search is displayed
	And user enters the search text