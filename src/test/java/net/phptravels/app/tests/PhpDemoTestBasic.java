package net.phptravels.app.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.test.ui.BaseTest;
import com.accenture.test.ui.WebDriverSteps;

import net.phptravels.app.steps.HomePageSteps;
import net.phptravels.app.steps.SearchPageSteps;

/**
 * Created to show how the required exercises can be solved.
 *
 * @author l.sanchez.farias
 *
 */
public class PhpDemoTestBasic extends BaseTest {

    private static final String DESTINATION = "Mazatlan";
    private static final String CHECK_IN_DATE = "20/12/2019";
    private static final String CHECK_OUT_DATE = "21/12/2019";
    private static final String HEADER_HOTEL_ICON_PARTIAL_URL = "/m-hotels";

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

    @Test(groups = { "HomePage" })
    public void testDemo() {
        // PART1 (Same As basic)
        HomePageSteps.getReservationModuleSteps().setBasicSearchDataInHotelsTab(DESTINATION, CHECK_IN_DATE, CHECK_OUT_DATE);
        HomePageSteps.getReservationModuleSteps().hitSearchButtonAndWaitForResultsPageToLoad();
        SearchPageSteps.validateSearchPageLoad();
        SearchPageSteps.getHeaderModuleSteps().validateHighlightedHeaderMenuOptionLink(HEADER_HOTEL_ICON_PARTIAL_URL);
    }

}
