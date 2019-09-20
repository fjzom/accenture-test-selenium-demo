package net.phptravels.app.steps;

import org.testng.Assert;

import com.accenture.test.ui.Wait;

import net.phptravels.app.pages.OfferPage;
import net.phptravels.app.pages.SignInPage;

/**
 * Created to support/Hold Common logic/behaviors that can be reused across many different tests for OfferPage
 *
 * @author l.sanchez.farias
 *
 */
public class OfferPageSteps {

    private static final String LOGIN_PARTIAL_URL = "/login";

    /**
     * All the pages display the Default Header Module, to use a more particular behavior use a cast once you call this method.
     */
    public static MultiplePageHeaderModuleSteps getHeaderModuleSteps() {
        MultiplePageHeaderModuleSteps headerModuleSteps = new MultiplePageHeaderModuleSteps();
        return headerModuleSteps;
    }

    public static final void validateLoginPageLoads() {
        getHeaderModuleSteps().goTologinPage();
        SignInPageSteps.waitUntilPageLoads();
        Assert.assertTrue(SignInPage.getWebDriverSession().getCurrentUrl().contains(LOGIN_PARTIAL_URL));
    }

    public static void waitUntilPageLoads() {
        OfferPage offerPage = new OfferPage();
        Wait.waitForElementVisibilityLongWait(offerPage.footerPageLogo);
    }
}
