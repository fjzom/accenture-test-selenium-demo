@AllTests @SimpleTest2
Feature: Demo Google Search page Script 2
	I want to use this template for my feature file

@tag1
Scenario: Validate the GOOGLE search functionality
Given User navigates to "GOOGLE"
And User search for "Test"	
Then Check the tabs displayed in results page


Scenario Outline: Validate the user can navigate to the Videos tab
Given User navigates to "GOOGLE"
And User search for "<value>"	
Then Click on the Videos tab

Examples:
    |value |
    | Test |
    | Accenture |
