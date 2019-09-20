package com.clientname.app.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.test.ui.BaseTest;
import com.accenture.test.ui.WebDriverSteps;
import com.clientname.app.steps.ResultsSteps;
import com.clientname.app.steps.SearchSteps;

public class Example_SimpleTest2 extends BaseTest {

	 @BeforeMethod (alwaysRun = true)
	 public void beforeTest() throws IOException { 
		WebDriverSteps nav = new WebDriverSteps();
		nav.navigateToApplication("GOOGLE");

	 }
		
	 @Test (groups = {"ALLTests", "Test1", "Smoke"})
	  public void testGoogleSearch3() {
		 SearchSteps.searchFor("Test");
		 ResultsSteps.checkTabsInResult();
		 WebDriverSteps.closeTheBrowser(); 
		 
	 }
	  
	 @Test (groups = {"ALLTests","Test2"})
	  public void testGoogleSearch4() {

		 SearchSteps.searchFor("Test");
		 ResultsSteps.clickVideosTabInResult();
		 WebDriverSteps.closeTheBrowser();
		  
	  }

	  
	 @AfterMethod(alwaysRun = true)
	  public synchronized void afterTest() {

	  }
}
