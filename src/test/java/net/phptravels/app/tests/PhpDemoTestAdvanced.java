package net.phptravels.app.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.test.ui.BaseTest;
import com.accenture.test.ui.WebDriverSteps;

import net.phptravels.app.steps.HomePageSteps;
import net.phptravels.app.steps.IntegrationSteps;
import net.phptravels.app.steps.OfferPageSteps;
import net.phptravels.app.steps.SearchPageSteps;

/**
 * Created to show how the required exercises can be solved.
 *
 * @author l.sanchez.farias
 *
 */
public class PhpDemoTestAdvanced extends BaseTest {

    private static final String DESTINATION = "Mazatlan";
    private static final String CHECK_IN_DATE = "20/12/2019";
    private static final String CHECK_OUT_DATE = "21/12/2019";

    private static final String OFFERS_PARTIAL_URL = "/offers";
    private static final String HOME_PARTIAL_URL = "www.phptravels.net";
    private static final String HEADER_HOTEL_ICON_PARTIAL_URL = "/m-hotels";

    private static final int NUMBER_TWO = 2;

    @AfterMethod(alwaysRun = true)
    public synchronized void afterTest() {
        WebDriverSteps.closeTheBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws IOException {
        WebDriverSteps nav = new WebDriverSteps();
        nav.navigateToApplication("PHP_TRAVELS");
        HomePageSteps.waitUntilPageLoads();
    }

    @Test(groups = { "HomePage", "SearchPage" })
    public void test_Demo_Advanced_P1() {
        // PART1 (Same As basic)
        IntegrationSteps.doBasicSearchFromHomeToSearchResultsPage(DESTINATION, CHECK_IN_DATE, CHECK_OUT_DATE);
        SearchPageSteps.getHeaderModuleSteps().validateHighlightedHeaderMenuOptionLink(HEADER_HOTEL_ICON_PARTIAL_URL);

        // PART2 (Same As Medium)
        SearchPageSteps.waitUntilPageLoads();
        SearchPageSteps.validateBasicContentFromResultsListUsingRandomElement();

        // PART3 (Advanced P1)
        SearchPageSteps.setStarsFilterApplyAndValidateResults(NUMBER_TWO);
    }

    @Test(groups = { "HomePage", "SearchPage", "OfferPage" })
    public void test_Demo_Advanced_P2() { // EXAMPLE OF SAME LOGIC SHARED BY THE PAGES BY USING THE SAME MODULE
        SearchPageSteps.getHeaderModuleSteps().validateHighlightedHeaderMenuOptionLink(OFFERS_PARTIAL_URL);
        OfferPageSteps.getHeaderModuleSteps().validateHighlightedHeaderMenuOptionLink(HOME_PARTIAL_URL);
    }

    @Test(groups = { "HomePage", "LoginPage" })
    public void test_Demo_Advanced_P3_LoginFromHomePage() { // EXAMPLE OF SAME LOGIC SHARED BY THE PAGES BY USING THE SAME MODULE
        HomePageSteps.validateLoginPageLoads();
    }

    @Test(groups = { "OfferPage", "LoginPage" })
    public void test_Demo_Advanced_P3_LoginFromOfferPage() { // EXAMPLE OF SAME LOGIC SHARED BY THE PAGES BY USING THE SAME MODULE
        OfferPageSteps.validateLoginPageLoads();
    }

    @Test(groups = { "SearchPage", "LoginPage" })
    public void test_Demo_Advanced_P3_LoginFromSearchPage() { // EXAMPLE OF SAME LOGIC SHARED BY THE PAGES BY USING THE SAME MODULE
        SearchPageSteps.validateLoginPageLoads();
    }
}
