@functional_tests_login_to_casino
@pack
Feature: William hill login 
	As a user I should able to login to casino
 
Scenario: Login with valid credential 
	Given I navigate to https://williamhill.com
	And I navigate to https:/sports.williamhill.com
	And I wait for 5 sec
	Then I close browser