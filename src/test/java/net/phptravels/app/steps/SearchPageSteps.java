package net.phptravels.app.steps;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Validate;
import com.accenture.test.ui.Wait;
import com.accenture.test.ui.WebDriverSteps;

import cucumber.api.java.en.Then;
import net.phptravels.app.pages.SearchPage;
import net.phptravels.app.pages.SignInPage;

/**
 * Created to support/Hold Common logic/behaviors that can be reused across many different tests for SearchPage
 *
 * @author l.sanchez.farias
 *
 */
public class SearchPageSteps {

    private static final int INDEX_ZERO = 0;
    private static final int PAUSE_5000 = 5000;
    private static final String LOGIN_PARTIAL_URL = "/login";
    private static final String SEARCH_PARTIAL_URL = "/hotels/search/";

    private static final int STARS_FILTER_TWO = 2;

    private static WebElement getCityInSearchResultsElement(WebElement w) {
        return w.findElement(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_CITY));
    }

    private static WebElement getCurrencyAndPriceInSearchResultsElement(WebElement w) {
        return w.findElement(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_CURRENCY_AND_PRICE));
    }

    private static WebElement getDetaislButtonInSearchResultsElement(WebElement w) {
        return w.findElement(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_DETAILS_BUTTON));
    }

    /**
     * All the pages display the Default Header Module, to use a more particular behavior use a cast once you call this method.
     */
    public static MultiplePageHeaderModuleSteps getHeaderModuleSteps() {
        MultiplePageHeaderModuleSteps headerModuleSteps = new MultiplePageHeaderModuleSteps();
        return headerModuleSteps;
    }

    /**
     * From the results list, this method return a random element (row)
     *
     * @return
     */
    private static WebElement getRandomElementFromResultList() {
        Random random = new Random();
        int index = random.nextInt(getResultsTableElementList().size());
        return getResultsTableElementList().get(index);
    }

    private static WebElement getRateStarInSearchResultsElement(WebElement w) {
        return w.findElements(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_STARS)).get(INDEX_ZERO);
    }

    /**
     * This method retrieves the #of filled stars from a Element in the Search Results Table
     *
     * @param w
     * @return
     */
    private static int getRatingStarFillCountInSearchResultsElementDisplayed(WebElement w) {
        return w.findElements(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_STARS_RATING_FILL)).size();
    }

    /**
     * From the results list, this method return all the elements (rows) that are visible at the moment, there might be more elements but they are not visible
     *
     * @return
     */
    private static List<WebElement> getResultsTableElementList() {
        SearchPage searchPage = new SearchPage();
        waitUntilSearchResultsTableIsDisplayed();
        return searchPage.searchResultsTableVisibleElements;
    }

    private static WebElement getSmallDescriptionInSearchResultsElement(WebElement w) {
        return w.findElement(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_SMALL_DESCRIPTION));
    }

    /**
     * Method to get the Filter Option (Stars checKbox) to Click
     *
     * @param index
     */
    private static WebElement getStarsCheckboxByIndex(int index) {
        SearchPage searchPage = new SearchPage();
        List<WebElement> list = searchPage.starGradeOptions;

        if (index >= list.size()) {
            throw new UnsupportedOperationException("Required index do not exists");
        }

        return list.get(index);
    }

    private static WebElement getTitleInSearchResultsElement(WebElement w) {
        return w.findElement(By.cssSelector(SearchPage.SEARCH_RESULTS_ELEMENT_TITLE));
    }

    /**
     * Hide the Cookie Banner that overlaps other elements
     */
    private static void hideCookieBanner() {
        SearchPage searchPage = new SearchPage();
        Action.clickElement(searchPage.cookiesBannerGotItButton);
        Wait.waitForElementInvisibilitySmallWait(searchPage.cookiesBannerGotItButton);
    }

    /**
     * Returns if the Cookie Banner that overlaps other elements is displayed
     *
     * @return
     */
    private static boolean isCookiesBannerDisplayed() {
        SearchPage searchPage = new SearchPage();
        return Validate.isElementDisplayed(searchPage.cookiesBannerGotItButton);
    }

    /**
     * To set the Stars Filter using a specific number 1 to 5 and apply the search
     *
     * @param numberOfStarsFilterToApply
     */
    public static void setStarsFilterAndApplySearch(int numberOfStarsFilterToApply) {
        SearchPage searchPage = new SearchPage();
        waitUntilFilterMainContainerIsDisplayed();

        Action.clickElement(getStarsCheckboxByIndex(numberOfStarsFilterToApply - 1));// Less 1 , as the list works by index

        if (isCookiesBannerDisplayed()) {
            hideCookieBanner();
        }

        Action.clickElement(searchPage.filterSearchButton);
        waitUntilResultsListIsRefreshed();
    }

    /**
     * Apply a custom Star filter and validate the results are matching the expected stars for a random element
     */
    @Then("User set (\\d+) stars as filters, apply the filter and validate the filter is applied in one random hotel Element")
    public static void setStarsFilterApplyAndValidateResults(int numberOfStarsFilterToApply) {
        setStarsFilterAndApplySearch(numberOfStarsFilterToApply);
        validateStarsFilterSearchDoneReviewingRandomElement(numberOfStarsFilterToApply);
    }

    /**
     * Validate one random element from the list, to contain all the expected basic properties visible
     */
    @Then("User Select a random hotel from Results List and validate it displays the basic Elements like Title/City/RateStar/SmallDescription/CurrencyAndPrice/DetailsButton")
    public static void validateBasicContentFromResultsListUsingRandomElement() {
        waitUntilSearchResultsTableIsDisplayed();
        Assert.assertFalse(getResultsTableElementList().isEmpty());

        WebElement w = getRandomElementFromResultList();
        validateBasicContentFromResultsListUsingSpecificElement(w);
    }

    /**
     * Validate one specific element from the list, to contain all the expected basic properties visible
     */
    private static void validateBasicContentFromResultsListUsingSpecificElement(WebElement w) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Validate.isElementDisplayed(getTitleInSearchResultsElement(w)));
        softAssert.assertTrue(Validate.isElementDisplayed(getCityInSearchResultsElement(w)));
        softAssert.assertTrue(Validate.isElementDisplayed(getRateStarInSearchResultsElement(w)));
        softAssert.assertTrue(Validate.isElementDisplayed(getSmallDescriptionInSearchResultsElement(w)));

        // softAssert.assertTrue(Validate.elementDisplayed(getCurrencyAndPriceInSearchResultsElement(w))); //NOT ALWAYS DISPLAYED
        softAssert.assertTrue(Validate.isElementDisplayed(getDetaislButtonInSearchResultsElement(w)));
        softAssert.assertAll();
    }

    public static final void validateLoginPageLoads() {
        getHeaderModuleSteps().goTologinPage();
        SignInPageSteps.waitUntilPageLoads();
        Assert.assertTrue(SignInPage.getWebDriverSession().getCurrentUrl().contains(LOGIN_PARTIAL_URL));
    }

    @Then("Validate the Search Result Page loads")
    public static void validateSearchPageLoad() {
        waitUntilPageLoads();
        Assert.assertTrue(WebDriverSteps.getCurrentUrl().contains(SEARCH_PARTIAL_URL));
    }

    /**
     * Validate the #of stars filled that a random Element from the results contains.
     *
     * @param numberOfStarsFilterToApply
     */
    public static void validateStarsFilterSearchDoneReviewingRandomElement(int numberOfStarsFilterToApply) {
        WebElement w = getRandomElementFromResultList();
        int numberOfFilledStars = getRatingStarFillCountInSearchResultsElementDisplayed(w);
        Assert.assertTrue(numberOfFilledStars == numberOfStarsFilterToApply); // Expected to be intermittent as the application is not really filtering the data, So according to
                                                                              // the selected element it might fail.
    }

    /**
     * Wait for the Filter Main container to be displayed
     */
    private static void waitUntilFilterMainContainerIsDisplayed() {
        SearchPage searchPage = new SearchPage();
        Wait.waitForElementVisibilitySmallWait(searchPage.filterMainContainer);
    }

    /**
     * Wait until the page is loaded
     */
    @Then("User reach SearchPage Wait Until the page Load")
    public static void waitUntilPageLoads() {
        waitUntilFilterMainContainerIsDisplayed();
    }

    /**
     * Wait for the Results table to be refreshed and displayed
     */
    private static void waitUntilResultsListIsRefreshed() {
        Wait.genericWait(PAUSE_5000); // Need to invest more time to find a suitable wait for this refresh - probably a wait for a stale element
        waitUntilSearchResultsTableIsDisplayed();
    }

    /**
     * Wait for the Results table to be displayed
     */
    private static void waitUntilSearchResultsTableIsDisplayed() {
        SearchPage searchPage = new SearchPage();
        Wait.waitForElementVisibilitySmallWait(searchPage.searchResultsTableMainContainer);
    }
}
