package net.phptravels.app.steps;

import cucumber.api.java.en.Given;

/**
 * Class to support integration methods (Flow interactions between pages)
 *
 * @author l.sanchez.farias
 *
 */
public class IntegrationSteps {

    private static final String HEADER_HOTEL_ICON_PARTIAL_URL = "/m-hotels";

    /**
     * Navigate From Home to Search Results with Default Search Data, basic assertions are call during this flow.
     */
    @Given("User Do a Default Basic Search and assert it takes you to Results page with basic assertions")
    public static void doBasicSearchFromHomeToSearchResultsPage() {
        // PART1 (Same As basic)
        HomePageSteps.getReservationModuleSteps().setBasicSearchDataInHotelsTab();
        HomePageSteps.getReservationModuleSteps().hitSearchButtonAndWaitForResultsPageToLoad();
        SearchPageSteps.validateSearchPageLoad();
    }

    /**
     * Navigate From Home to Search Results with Default Search Data, basic assertions are call during this flow.
     */
    @Given("User Do a Custom Basic Search and assert it takes you to Results page with basic assertions")
    public static void doBasicSearchFromHomeToSearchResultsPage(String destination, String checkInAsText, String checkOutAsText) {
        // PART1 (Same As basic)
        HomePageSteps.getReservationModuleSteps().setBasicSearchDataInHotelsTab(destination, checkInAsText, checkOutAsText);
        HomePageSteps.getReservationModuleSteps().hitSearchButtonAndWaitForResultsPageToLoad();
        SearchPageSteps.validateSearchPageLoad();
    }

}
