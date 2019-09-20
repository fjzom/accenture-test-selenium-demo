@AllTests @SimpleTest3

Feature: Basic Search Transition From 'Home' To Search 'Results Page' reviewing a random hotel result data, modify filter criteria and then assert it is applied

Background:
Given User navigates to "PHP_TRAVELS"
Given User Do a Default Basic Search and assert it takes you to Results page with basic assertions

Scenario: User Navigate from Home to Search page doing a valid search, select a Random Hotel From the results and do basic assertions of expected content, and then apply filter criteria and validates is applied
When User reach SearchPage Wait Until the page Load
Then User Select a random hotel from Results List and validate it displays the basic Elements like Title/City/RateStar/SmallDescription/CurrencyAndPrice/DetailsButton
And User set 2 stars as filters, apply the filter and validate the filter is applied in one random hotel Element

And Close the browser

