@functional_tests_test 
@pack 
Feature: Test page login 
	As a user I should able to login to selenium test page
 
Scenario: I login with valid credential 
	Given I navigate to http://the-internet.herokuapp.com/login 
		And enter username 
		And enter password 
		#And I enter "tomsmith" into input field having id "username"
		# And I enter "SuperSecretPassword!" into input field having id "password"
		When I click on element having class "radius" 
	And I wait for 5 sec 
	Then I close browser