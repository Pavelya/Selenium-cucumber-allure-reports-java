@functional_tests_login_to_casino 
@pack 
@Q 
Feature: Casino login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given  I print configuration 
	And I navigate to https://casino.williamhill.com 
	Then I maximize browser window 
	
Scenario: Login with valid credential II FAILED
	Given  I print configuration 
	And I navigate to https://casino.williamhill.com 
	Then I maximize browser window 
	And I should see page title as "AAA"