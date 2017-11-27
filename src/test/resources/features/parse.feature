@functional_tests_login_to_casino 
@pack1
Feature: Casino login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given  I navigate to https://tv4kids.tk 
	#Then I should see page source 
	And I wait for 5 sec 
	#Then I close browser