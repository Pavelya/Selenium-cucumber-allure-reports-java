@functional_tests_login_to_casino 
@pack 
Feature: Casino login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given I navigate to https://casino.williamhill.com
	And I print configuration 
	Then I maximize browser window 
	And I wait for 5 sec 
	Then I close browser