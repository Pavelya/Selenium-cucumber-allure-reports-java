@header
Feature: Header 
	As a user I should able to see header
 
Scenario: Header 
	Given  I print configuration 
	And I navigate to https://declarator.org/
	Then my header is displayed