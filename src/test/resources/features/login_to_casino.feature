@functional_tests_login_to_casino 
@pack
Feature: Casino login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given  I print configuration 
	And I navigate to https://casino.williamhill.com 
	Then I maximize browser window 
	And I wait for 5 sec 
	#Then I close browser