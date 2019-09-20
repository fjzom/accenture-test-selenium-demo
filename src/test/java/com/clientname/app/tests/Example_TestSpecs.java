package com.clientname.app.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.test.ui.BaseTest;
import com.accenture.test.utils.TestSpecs;
import com.clientname.app.steps.PrintTestSpecsSteps;

public class Example_TestSpecs extends BaseTest{
	
	String jsonFile = "\\testSpecs\\TestSpecs_SimpleSpecs.json";
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		testData = TestSpecs.processTestSpec(jsonFile);
	}
	
	@Test(groups = { "DB"})
	public void scenarioDB() {
        PrintTestSpecsSteps.printTestSpecs(testData);
	}
	
}
