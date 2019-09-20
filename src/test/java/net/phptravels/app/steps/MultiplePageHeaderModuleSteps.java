package net.phptravels.app.steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Validate;

import cucumber.api.java.en.Then;
import net.phptravels.app.pages.MultiplePageHeaderModule;
import net.phptravels.app.pages.OfferPage;

/**
 * Created to support the Specific behavior of Header module that is used in the pages: SearchPage/OfferPage/LoginPage
 *
 * @author l.sanchez.farias
 *
 */
public class MultiplePageHeaderModuleSteps extends DefaultHeaderModuleSteps {

    /**
     * Element Options in menu for Multiple pages, (Excluding Homepage)
     * 
     * @author l.sanchez.farias
     */
    public static enum PageHeaderMenuOptions {

        BLOG("https://www.phptravels.net/blog"),
        CARS("https://www.phptravels.net/m-cars"),
        FLIGHTS("https://www.phptravels.net/m-flights"),
        HOME("https://www.phptravels.net/"),
        HOTELS("https://www.phptravels.net/m-hotels"),
        OFFERS("https://www.phptravels.net/offers"),
        TOURS("https://www.phptravels.net/m-tours"),
        VISA("https://www.phptravels.net/m-ivisa");

        private String itemPartialLink;

        PageHeaderMenuOptions(String itemPartialLink) {
            this.itemPartialLink = itemPartialLink;
        }

        public String getPartialLink() {
            return this.itemPartialLink;
        }
    }

    private static final String HREF_ATTRIBUTE = "href";

    /**
     * Get the HREF from the (Active) Highlighted element
     * 
     * @return
     */
    private static String getHighlightedMenuOptionHref() {
        MultiplePageHeaderModule largeVersionHeaderModule = new MultiplePageHeaderModule();
        return largeVersionHeaderModule.highlightedMenuOption.getAttribute(HREF_ATTRIBUTE);
    }

    /**
     * Get an element form the menu option, asserting that exist.
     * 
     * @param menuOption
     * @return
     */
    private static WebElement getMenuOptionElement(PageHeaderMenuOptions menuOption) {
        MultiplePageHeaderModule searchPageHeaderModule = new MultiplePageHeaderModule();

        for (WebElement e : searchPageHeaderModule.menuOptionsList) {
            String href = e.getAttribute(HREF_ATTRIBUTE);
            if (href.equalsIgnoreCase(menuOption.getPartialLink())) {
                return e;
            }
        }
        throw new UnsupportedOperationException("Element to click Not Found");
    }

    /**
     * To validate the Header Menu Option inspecting the href looking for a expected partial link
     */
    public static final void validateHeaderMenuOptionLink(MultiplePageHeaderModuleSteps.PageHeaderMenuOptions menuOption, String expectedPartialLink) {
        MultiplePageHeaderModule largeVersionHeaderModule = new MultiplePageHeaderModule();
        Assert.assertTrue(Validate.isElementDisplayed(largeVersionHeaderModule.phpTravelsIcon));
        Action.clickElement(MultiplePageHeaderModuleSteps.getMenuOptionElement(menuOption));
        // TODO WAIT
        // Wait.waitForElement(element, seconds);
        Assert.assertTrue(OfferPage.getWebDriverSession().getCurrentUrl().contains(expectedPartialLink));
    }

    /**
     * Validate the Header Highlighted element Link
     *
     * @param partialUrl
     */
    @Then("Validate the Search Result Page Header has Higlighted the element with the partial URL \"([^\"]*)\"$")
    public static void validateHighlightedHeaderMenuOptionLink(String partialUrl) {
        Assert.assertTrue(getHighlightedMenuOptionHref().contains(partialUrl));
    }
}
