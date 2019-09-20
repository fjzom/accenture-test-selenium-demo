package com.clientname.app.steps;

import org.openqa.selenium.Keys;

import com.clientname.app.pages.SearchPage;

import cucumber.api.java.en.*;

public class SearchSteps {
		
	@Given("User search for \"([^\"]*)\"$" )	
    public static void searchFor(String strText) {
		SearchPage searchPage = new SearchPage();
	
		System.out.println("Start: Search for " + strText);	
		searchPage.googleSearchBox.sendKeys(strText);
		System.out.println("Click on Search button");
		searchPage.googleSearchBox.sendKeys(Keys.ENTER);
    }
			
}
