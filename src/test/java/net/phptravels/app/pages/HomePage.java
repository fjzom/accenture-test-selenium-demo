package net.phptravels.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenture.test.ui.WebDriverSession;

/**
 * Created to support the PHP Travel HomePage
 *
 * @author l.sanchez.farias
 *
 */
public class HomePage extends WebDriverSession {

    @FindBy(css = "#footer .text-center img") public WebElement footerPageLogo;

    @FindBy(css = "#flights .checkbox[value='round']") public WebElement dummyNotVisible;
    @FindBy(css = "#li_myaccount.open .dropdown-menu") public WebElement dummyNotPresent; // Until the account dropdown is opened.
    @FindBy(css = "ul .select2-result-sub") public WebElement dummydelayedElement;

    public HomePage() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
