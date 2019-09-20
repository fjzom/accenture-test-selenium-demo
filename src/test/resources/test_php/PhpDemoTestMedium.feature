@AllTests @SimpleTest2

Feature: Basic Search Transition From 'Home' To Search 'Results Page' reviewing a random hotel result data

Background:
Given User navigates to "PHP_TRAVELS"

Scenario: User Navigate from Home to Search page doing a valid search, select a Random Hotel From the results and do basic assertions of expected content
Given User Do a Default Basic Search and assert it takes you to Results page with basic assertions
When User reach SearchPage Wait Until the page Load
Then User Select a random hotel from Results List and validate it displays the basic Elements like Title/City/RateStar/SmallDescription/CurrencyAndPrice/DetailsButton
And Close the browser

