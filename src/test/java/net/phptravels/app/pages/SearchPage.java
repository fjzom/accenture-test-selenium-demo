package net.phptravels.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenture.test.ui.WebDriverSession;

/**
 * Created to support the PHP Travel SearchPage
 *
 * @author l.sanchez.farias
 *
 */
public class SearchPage extends WebDriverSession {

    // Helpers to get Elements from Results Element
    public static final String SEARCH_RESULTS_ELEMENT_DETAILS_BUTTON = " .btn";
    public static final String SEARCH_RESULTS_ELEMENT_CURRENCY_AND_PRICE = " .price_tab .text-center";
    public static final String SEARCH_RESULTS_ELEMENT_TITLE = " .list_title";
    public static final String SEARCH_RESULTS_ELEMENT_STARS = " .star";
    public static final String SEARCH_RESULTS_ELEMENT_STARS_RATING_FILL = " i.star:not(.fa-star-o)";
    public static final String SEARCH_RESULTS_ELEMENT_CITY = " .ellipsisFIX";
    public static final String SEARCH_RESULTS_ELEMENT_SMALL_DESCRIPTION = " .fs12";

    @FindBy(css = ".footbrand.nopadding") public WebElement footerPageLogo;
    @FindBy(css = ".table.table-striped") public WebElement searchResultsTableMainContainer;
    /**
     * There are more elements that are not visible (depending on your viewport size)
     */
    @FindBy(css = ".table.table-striped td[style*='visibility: visible;']") public List<WebElement> searchResultsTableVisibleElements;
    @FindBy(css = ".filter") public WebElement filterMainContainer;
    @FindBy(css = "#collapse1 .iradio_square-grey") public List<WebElement> starGradeOptions;
    @FindBy(css = "#collapse1 .iradio_square-grey.checked") public WebElement starGradeOptionSelected;
    @FindBy(css = "#searchform") public WebElement filterSearchButton;
    @FindBy(css = "#cookyGotItBtnBox button") public WebElement cookiesBannerGotItButton;

    public SearchPage() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
