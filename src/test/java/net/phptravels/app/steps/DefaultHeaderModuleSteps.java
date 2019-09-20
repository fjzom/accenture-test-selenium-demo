package net.phptravels.app.steps;

import org.openqa.selenium.WebElement;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Wait;

import net.phptravels.app.pages.DefaultHeaderModule;

/**
 * Created to support Header Module, that has the 95% of Common Behaviors across all the other children versions
 *
 * @author l.sanchez.farias
 *
 */
public class DefaultHeaderModuleSteps {

    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;

    private static WebElement getMyAccountElement() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountElements.get(INDEX_ONE);
    }

    private static WebElement getMyAccountOptionLoginElement() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountOptions.get(INDEX_ZERO);
    }

    private static WebElement getMyAccountOptionSignUpElement() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountOptions.get(INDEX_ONE);
    }

    /**
     * Goto Login Page using the Header Module
     */
    public static void goTologinPage() {
        waitUntilHeaderModuleIsDisplayed();

        Action.clickElement(getMyAccountElement());
        waitUntilMyAccountDropDownMenuIsDisplayed();

        Action.clickElement(getMyAccountOptionLoginElement());
    }

    /**
     * Validate the Header Account options are Hidden after select One of the options.
     */
    public static void validateHeaderAccountOptionsAreHiddenAfterSelectOne() {
        waitUntilHeaderModuleIsDisplayed();

        Action.clickElement(getMyAccountElement()); // Will open the options
        // Click.clickElement(getHeaderModuleSteps().getMyAccountOptionLogin());//Commented to make the test fail, by using the validation.
        Wait.waitForElementInvisibilitySmallWait(getMyAccountOptionLoginElement());
    }

    /**
     * Wait Until the Header Module is displayed
     */
    public static void waitUntilHeaderModuleIsDisplayed() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        Wait.waitForElementVisibilitySmallWait(defaultHeaderModule.phpTravelsIcon);
        Wait.waitForElementVisibilitySmallWait(getMyAccountElement());
    }

    /**
     * Wait Until the My Account Dropdown Menu is displayed
     */
    public static void waitUntilMyAccountDropDownMenuIsDisplayed() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        Wait.waitForElementVisibilitySmallWait(defaultHeaderModule.myAccountOpenMenu);
    }
}
