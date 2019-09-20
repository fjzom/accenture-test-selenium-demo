package com.clientname.app.tests;

import com.accenture.test.ui.WebDriverSteps;
import com.accenture.test.ui.BaseTest;
import com.accenture.test.utils.TestSpecs;
import com.clientname.app.steps.ResultsSteps;
import com.clientname.app.steps.SearchSteps;
import java.io.IOException;
import org.testng.annotations.*;
/**
 ****************************************************************************
 *HIGHLIGHTS:
 * > SCRIPT NAME:
 * > DESCRIPTION:
 * > DATA:
 ****************************************************************************
 */
public class Example_SimpleTest1 extends BaseTest {

 @BeforeMethod (alwaysRun = true)
 public void beforeTest() throws IOException { 
	 //Example of how to obtain data from testSpec json
	 	testData = TestSpecs.processTestSpec("\\testSpecs\\TestSpecs_SimpleTest1.json");		
		WebDriverSteps.openApplication(testData.getString("Application"));		

 }

	
	
 @Test (groups = {"ALLTests", "Test1", "Smoke"})
  public void testGoogleSearch() {
	 SearchSteps.searchFor(testData.getString("SearchCriteria"));
	 ResultsSteps.checkTabsInResult();
	 WebDriverSteps.closeTheBrowser(); 
	 
 }
  
 @Test (groups = {"ALLTests","Test2"})
  public void testGoogleSearch2() {

	 SearchSteps.searchFor(testData.getString("SearchCriteria"));
	 ResultsSteps.clickVideosTabInResult();
	 WebDriverSteps.closeTheBrowser();
	  
  }

  
 @AfterMethod(alwaysRun = true)
  public void afterTest() {

  }
 
 
}
