package net.phptravels.app.steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Validate;

import net.phptravels.app.pages.DefaultHeaderModule;
import net.phptravels.app.pages.HomePageHeaderModule;
import net.phptravels.app.pages.SearchPage;

/**
 * Created to support the Specific behavior of Header module for the HomePage
 *
 * @author l.sanchez.farias
 *
 */
public class HomePageHeaderModuleSteps extends DefaultHeaderModuleSteps {

    /**
     * Element Options in menu for HOMEPAGE
     *
     * @author l.sanchez.farias
     */
    public static enum PageHeaderMenuOptions {

        BLOG("https://www.phptravels.net/blog"),
        HOME("https://www.phptravels.net/"),
        OFFERS("https://www.phptravels.net/offers");

        private String itemPartialLink;

        PageHeaderMenuOptions(String itemPartialLink) {
            this.itemPartialLink = itemPartialLink;
        }

        public String getPartialLink() {
            return this.itemPartialLink;
        }

    }

    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final String HREF_ATTRIBUTE = "href";

    /**
     * Get an element form the menu option, asserting that exist.
     * 
     * @param menuOption
     * @return
     */
    private static WebElement getMenuOptionElement(PageHeaderMenuOptions menuOption) {
        HomePageHeaderModule homePageHeaderModule = new HomePageHeaderModule();

        for (WebElement e : homePageHeaderModule.menuOptionsList) {
            String href = e.getAttribute(HREF_ATTRIBUTE);
            if (href.equalsIgnoreCase(menuOption.getPartialLink())) {
                return e;
            }
        }
        throw new UnsupportedOperationException("Element Not Found");
    }

    private static WebElement getMyAccountElement() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountElements.get(INDEX_ONE);
    }

    public static WebElement getMyAccountOptionLogin() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountOptions.get(INDEX_ZERO);
    }

    public static WebElement getMyAccountOptionSignUp() {
        DefaultHeaderModule defaultHeaderModule = new DefaultHeaderModule();
        return defaultHeaderModule.myAccountOptions.get(INDEX_ONE);
    }

    /**
     * To validate the Header Menu Option inspecting the href looking for a expected partial link
     */
    public static final void validateHeaderMenuOptionLink(HomePageHeaderModuleSteps.PageHeaderMenuOptions menuOption, String expectedPartialLink) {
        HomePageHeaderModule homeHeaderModule = new HomePageHeaderModule();
        Assert.assertTrue(Validate.isElementDisplayed(homeHeaderModule.phpTravelsIcon));
        Action.clickElement(HomePageHeaderModuleSteps.getMenuOptionElement(menuOption));
        Assert.assertTrue(SearchPage.getWebDriverSession().getCurrentUrl().contains(expectedPartialLink));
    }
}
