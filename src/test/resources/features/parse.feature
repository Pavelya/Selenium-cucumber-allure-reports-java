@functional_tests_login_to_casino 
@pack11
Feature: Casino login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given  I navigate to http://localhost:8080/MARS/login.html
	Then I should see page source 
	And I wait for 10 sec 
	#Then I close browser
	
