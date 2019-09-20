package net.phptravels.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenture.test.ui.WebDriverSession;

/**
 * Created to support the PHP Travel OfferPage
 *
 * @author l.sanchez.farias
 *
 */
public class OfferPage extends WebDriverSession {

    @FindBy(css = ".footbrand.nopadding") public WebElement footerPageLogo;

    public OfferPage() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
