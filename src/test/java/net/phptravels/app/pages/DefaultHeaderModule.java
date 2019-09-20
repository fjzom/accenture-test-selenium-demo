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
public class DefaultHeaderModule extends WebDriverSession {

    @FindBy(css = "div.container .icon_set_1_icon-55") public WebElement callNowIcon;
    @FindBy(css = "div.container .contact-no") public WebElement callNowText;
    @FindBy(css = "div.container .contact-no a") public WebElement callNowNumber;
    @FindBy(css = "div.container .tp-mail a") public WebElement email;
    @FindBy(css = "div.container .navbar-header img") public WebElement phpTravelsIcon;
    @FindBy(css = "#li_myaccount .dropdown-toggle") public List<WebElement> myAccountElements;
    @FindBy(css = "#li_myaccount.open .dropdown-menu") public WebElement myAccountOpenMenu;
    @FindBy(css = "#li_myaccount.open .dropdown-menu a") public List<WebElement> myAccountOptions;

    public DefaultHeaderModule() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
