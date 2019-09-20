@AllTests @SimpleTest1

Feature: Demo Google Search page Script 1
	I want to use this template for my feature file

Scenario: Validate the GOOGLE search functionality
Given User navigates to "GOOGLE"
And User search for "Test"	
Then Check the tabs displayed in results page
And Close the browser

Scenario: Validate the user can navigate to the Videos tab
Given User navigates to "GOOGLE"
And User search for "Test"	
Then Click on the Videos tab
And Close the browser