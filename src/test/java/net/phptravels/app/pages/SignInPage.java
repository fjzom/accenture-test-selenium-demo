package net.phptravels.app.pages;

import java.util.List;

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
public class SignInPage extends WebDriverSession {

    @FindBy(css = "#loginfrm input[type='email']") public WebElement emailInputField;
    @FindBy(css = "#loginfrm input[type='password']") public List<WebElement> passwordInputField;
    @FindBy(css = "#loginfrm .loginbtn") public WebElement loginButton;

    public SignInPage() {

        PageFactory.initElements(getWebDriverSession(), this);

    }

}
