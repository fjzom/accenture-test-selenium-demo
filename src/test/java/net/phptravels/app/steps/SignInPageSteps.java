package net.phptravels.app.steps;

import com.accenture.test.ui.Wait;

import net.phptravels.app.pages.SignInPage;

/**
 * Created to support/Hold Common logic/behaviors that can be reused across many different tests for SignInPage
 *
 * @author l.sanchez.farias
 *
 */
public class SignInPageSteps {

    /**
     * All the pages display the Default Header Module, to use a more particular behavior use a cast once you call this method.
     */
    public static MultiplePageHeaderModuleSteps getHeaderModuleSteps() {
        MultiplePageHeaderModuleSteps headerModuleSteps = new MultiplePageHeaderModuleSteps();
        return headerModuleSteps;
    }

    /**
     * Wait until the page is loaded
     */
    public static void waitUntilPageLoads() {
        SignInPage signInPage = new SignInPage();
        Wait.waitForElementVisibilityLongWait(signInPage.loginButton);
    }

}
