@AllTests @SimpleTest1

Feature: Basic Search Transition From 'Home' To Search 'Results Page'

Scenario: Do a Default - Basic Search and assert it takes you to Results page with basic assertions
Given User navigates to "PHP_TRAVELS"
When User set in the Resmodule Any Existing Destination, Future CheckIn, Future CheckOut Dates
And Hit the Search Button and Wait for the Results Page to load
And Validate the Search Result Page loads 
Then Validate the Search Result Page Header has Higlighted the element with the partial URL "/m-hotels"
And Close the browser

