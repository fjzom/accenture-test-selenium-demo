package com.clientname.app.steps;

import org.testng.asserts.SoftAssert;

import com.accenture.test.ui.Action;
import com.accenture.test.ui.Validate;
import com.accenture.test.ui.Wait;
import com.clientname.app.pages.ResultsPage;

import cucumber.api.java.en.Then;

public class ResultsSteps {

    // **********************************************************
    // **********************************************************
    // This steps should be moved to a ResultsSteps
    @Then("Check the tabs displayed in results page")
    public static void checkTabsInResult() {
        ResultsPage resultsPage = new ResultsPage();
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start: Check Results Record: ");
        // Assertions
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabAll));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabImages));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabVideos));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabMaps));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabNews));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabSettings));
        softAssert.assertTrue(Validate.isElementDisplayed(resultsPage.tabTools));
        softAssert.assertAll();

    }

    @Then("Click on the Videos tab")
    public static void clickVideosTabInResult() {
        ResultsPage resultsPage = new ResultsPage();
        System.out.println("Start: Check Results Record: ");
        Wait.waitForElement(resultsPage.tabVideos, 10);
        Action.clickElement(resultsPage.tabVideos);
    }

}
