package net.phptravels.app.steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Wait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.phptravels.app.pages.HomePageReservationModule;

/**
 * Created to support the Specific behavior of reservation module for the HomePage
 *
 * @author l.sanchez.farias
 *
 */
public class HomePageReservationModuleSteps {

    private static final int INDEX_ZERO = 0;

    /**
     * To get the Hotel Tab from the Reservation Module
     *
     * @return WebElement
     */
    private static WebElement getHotelsTab() {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        return reservationModule.reservationModuleAllTabs.get(INDEX_ZERO);
    }

    /**
     * Hit the reservation Search Button and wait for the Search Page to load.
     */
    @Then("Hit the Search Button and Wait for the Results Page to load")
    public static void hitSearchButtonAndWaitForResultsPageToLoad() {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        Action.clickElement(reservationModule.reservationModuleHotelsTabSearchButton);
        SearchPageSteps.waitUntilPageLoads();
    }

    /**
     * Set the Default Basic Search Data in Resmodule HotelsTab Note: Data is Harcoded
     */
    @When("User set in the Resmodule Any Existing Destination, Future CheckIn, Future CheckOut Dates")
    public static void setBasicSearchDataInHotelsTab() {
        String destination = "Mazatlan";
        String checkInDate = "20/12/2019";
        String checkOutDate = "21/12/2019";

        setBasicSearchDataInHotelsTab(destination, checkInDate, checkOutDate);
    }

    /**
     * Set the Custom Basic Search Data in Resmodule HotelsTab
     */
    public static void setBasicSearchDataInHotelsTab(String destination, String checkInAsText, String checkOutAsText) {
        waitUntilReservationModuleIsDisplayed();
        Action.clickElement(getHotelsTab());
        setValidDestinationFirtsSuggestedItemInHotelsTabFromDefaultState(destination);
        setCheckInInHotelsTab(checkInAsText);
        setCheckOutInHotelsTab(checkOutAsText);
    }

    /**
     * Set the CheckIn in Resmodule HotelsTab
     */
    public static void setCheckInInHotelsTab(String dateAsText) {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        Action.clickElement(reservationModule.reservationModuleHotelsTabCheckInInput);
        reservationModule.reservationModuleHotelsTabCheckInInput.clear();
        reservationModule.reservationModuleHotelsTabCheckInInput.sendKeys(dateAsText);
    }

    /**
     * Set the CheckOut in Resmodule HotelsTab
     */
    public static void setCheckOutInHotelsTab(String dateAsText) {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        Action.clickElement(reservationModule.reservationModuleHotelsTabCheckOutInput);
        reservationModule.reservationModuleHotelsTabCheckOutInput.clear();
        reservationModule.reservationModuleHotelsTabCheckOutInput.sendKeys(dateAsText);
    }

    /**
     * Set the first result of a valid destination as the Main destination in the Resmodule HotelsTab
     */
    private static void setValidDestinationFirtsSuggestedItemInHotelsTabFromDefaultState(String destination) {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        Action.clickElement(reservationModule.reservationModuleHotelsTabDestinationInputDefaultLoadState);
        reservationModule.reservationModuleHotelsTabDestinationInputAfterClick.clear();
        reservationModule.reservationModuleHotelsTabDestinationInputAfterClick.sendKeys(destination);
        waitUntilDestinationLocationSuggestionListFirstElementIsDisplayed();

        reservationModule.reservationModuleHotelsTabDestinationInputAfterClick.sendKeys(Keys.TAB);
    }

    /**
     * Wait until the HomePage loads
     */
    private static void waitUntilDestinationLocationSuggestionListFirstElementIsDisplayed() {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        List<WebElement> list = reservationModule.reservationModuleHotelsTabDestinationLocationSuggestionList;
        Wait.waitUntilListFirstElementIsPresentLongWait(list);
        Wait.waitForElementVisibilitySmallWait(list.get(INDEX_ZERO));
    }

    /**
     * Wait until the ReservationModule loads
     */
    public static void waitUntilReservationModuleIsDisplayed() {
        HomePageReservationModule reservationModule = new HomePageReservationModule();
        Wait.waitForElementVisibilitySmallWait(reservationModule.reservationModuleMainContainer);
    }

}
