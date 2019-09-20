package net.phptravels.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created to support the Specific behavior of reservation module for the HomePage
 *
 * @author l.sanchez.farias
 *
 */
public class HomePageHeaderModule extends DefaultHeaderModule {

    @FindBy(css = ".collapse.navbar-collapse ul li.text-center a") public List<WebElement> menuOptionsList;
    @FindBy(css = ".collapse.navbar-collapse ul li.active.text-center a") public WebElement highlightedMenuOption;

    public HomePageHeaderModule() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
