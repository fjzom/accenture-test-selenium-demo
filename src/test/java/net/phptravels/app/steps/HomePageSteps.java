package net.phptravels.app.steps;

import org.testng.Assert;

import com.accenture.test.ui.Wait;

import net.phptravels.app.pages.HomePage;
import net.phptravels.app.pages.SignInPage;

/**
 * Created to support/Hold Common logic/behaviors that can be reused across many different tests for Homepage
 *
 * @author l.sanchez.farias
 *
 */
public class HomePageSteps {

    private static final String LOGIN_PARTIAL_URL = "/login";

    /**
     * All the pages display the Default Header Module, to use a more particular behavior use a cast once you call this method.
     */
    public static DefaultHeaderModuleSteps getHeaderModuleSteps() {
        DefaultHeaderModuleSteps defaultHeaderModuleSteps = new DefaultHeaderModuleSteps();
        return defaultHeaderModuleSteps;
    }

    /**
     * Inject the Resmodule supported by homepage
     */
    public static HomePageReservationModuleSteps getReservationModuleSteps() {
        HomePageReservationModuleSteps moduleSteps = new HomePageReservationModuleSteps();
        return moduleSteps;
    }

    /**
     * Goto Login Page by using the HeaderModule, wait until the page loads, then validate the url match the expected.
     */
    public static final void validateLoginPageLoads() {
        getHeaderModuleSteps().goTologinPage();
        SignInPageSteps.waitUntilPageLoads();
        Assert.assertTrue(SignInPage.getWebDriverSession().getCurrentUrl().contains(LOGIN_PARTIAL_URL));
    }

    /**
     * Wait until the HomePage loads
     */
    public static void waitUntilPageLoads() {
        HomePage homePage = new HomePage();
        Wait.waitForElementVisibilityLongWait(homePage.footerPageLogo);
    }

}
