package net.phptravels.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenture.test.ui.WebDriverSession;

/**
 * Created to support Header Module, that has the 95% of Common Behaviors across all the other children versions
 *
 * @author l.sanchez.farias
 *
 */
public class HomePageReservationModule extends WebDriverSession {

    @FindBy(css = ".col-md-12") public WebElement reservationModuleMainContainer;
    @FindBy(css = ".col-md-12 .nav.nav-tabs li") public List<WebElement> reservationModuleAllTabs;
    @FindBy(css = "#select2-drop .select2-search input.select2-input") public WebElement reservationModuleHotelsTabDestinationInputAfterClick;
    @FindBy(css = ".col-md-12 #hotels .select2-container.hotelsearch") public WebElement reservationModuleHotelsTabDestinationInputDefaultLoadState;
    @FindBy(css = "#select2-drop ul .select2-result-sub li") public List<WebElement> reservationModuleHotelsTabDestinationLocationSuggestionList;
    @FindBy(css = "#select2-drop .select2-results .select2-no-results") public WebElement reservationModuleHotelsTabDestinationLocationSuggestionNoResultsFound;
    @FindBy(css = ".col-md-12 #hotels #dpd1 input") public WebElement reservationModuleHotelsTabCheckInInput;
    @FindBy(css = ".col-md-12 #hotels #dpd2 input") public WebElement reservationModuleHotelsTabCheckOutInput;
    @FindBy(css = ".col-md-12 #hotels button.btn-primary") public WebElement reservationModuleHotelsTabSearchButton;

    public HomePageReservationModule() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
