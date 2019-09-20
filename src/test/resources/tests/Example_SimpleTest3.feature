@AllTests @SimpleTest3
Feature: Demo Google Search page Script 3
	I want to use this template for my feature file

Background: Enter the Portal Page
Given User navigates to "GOOGLE"

@tag1
Scenario: Validate the GOOGLE search functionality
And User search for "Test"	
Then Check the tabs displayed in results page
And Close the browser


@Mytag1
Scenario Outline: Validate the user can navigate to the Videos tab
And User search for "<value>"	
Then Click on the Videos tab
And Close the browser

Examples:
    | value |
    | Test |
    | Accenture |
