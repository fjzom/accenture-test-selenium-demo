package com.clientname.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenture.test.ui.WebDriverSession;

public class ResultsPage extends WebDriverSession{

    public ResultsPage() {

        PageFactory.initElements(getWebDriverSession(), this);

    }
    
    @FindBy(xpath = "//div[contains(text(),'All')]")
    public WebElement tabAll;
    
    @FindBy(xpath = "//a[contains(text(),'Images')]")
    public WebElement tabImages;   
    
    @FindBy(xpath = "//a[contains(text(),'Videos')]")
    public WebElement tabVideos;
    
    @FindBy(xpath = "//a[contains(text(),'Maps')]")
    public WebElement tabMaps;
    
    @FindBy(xpath = "//a[contains(text(),'News')]")
    public WebElement tabNews;         
    
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    public WebElement tabSettings;
    
    @FindBy(xpath = "//a[contains(text(),'Tools')]")
    public WebElement tabTools;

    
}
