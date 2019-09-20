package net.phptravels.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created to support the Specific behavior of reservation module that is used in the pages: SearchPage/OfferPage/LoginPage
 *
 * @author l.sanchez.farias
 *
 */
public class MultiplePageHeaderModule extends DefaultHeaderModule {

    @FindBy(css = ".collapse.navbar-collapse ul li.text-center a") public List<WebElement> menuOptionsList;
    @FindBy(css = ".collapse.navbar-collapse ul li.active.text-center a") public WebElement highlightedMenuOption;

    public MultiplePageHeaderModule() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
