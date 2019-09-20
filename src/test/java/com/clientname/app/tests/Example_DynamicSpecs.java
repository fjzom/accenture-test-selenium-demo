package com.clientname.app.tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.test.ui.BaseTest;
import com.accenture.test.utils.TestSpecs;
import com.clientname.app.steps.*;

public class Example_DynamicSpecs extends BaseTest {
	
	String jsonFileDynamic = "\\testSpecs\\TestSpecs_DynamicSpecs.json";
	JSONObject tdmData = new JSONObject();
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		
	}
	
	@Test(groups = { "TestSpec"})
	public void scenarioWireless() {
		tdmData = new JSONObject("{'dataRequirement':'WIRELESS ACCOUNT'}");
		testData = TestSpecs.processTestSpec(jsonFileDynamic, tdmData);
        PrintTestSpecsSteps.printTestSpecs(testData);
	}
	
	@Test(groups =  {"TestSpec"})
	public void scenarioTestSpec() {
		tdmData = new JSONObject("{'dataRequirement':'ROAMING FIX'}");
		testData = TestSpecs.processTestSpec(jsonFileDynamic, tdmData);
		PrintTestSpecsSteps.printTestSpecs(testData);
	}
	
	@Test(groups =  {"TestSpec"})
	public void scenarioTestSpecTwoParameters() {
		tdmData = new JSONObject("{'dataRequirement':'BAN and SUB with Sharing Group','accountType':'CONSUMER REGULAR'}");
		testData = TestSpecs.processTestSpec(jsonFileDynamic, tdmData);
		PrintTestSpecsSteps.printTestSpecs(testData);
	}
	
	@Test(groups = { "TestSpec"})
	public void scenarioWireline() {
		tdmData = new JSONObject("{'dataRequirement':'WIRELINE ACCOUNT'}");
		testData = TestSpecs.processTestSpec(jsonFileDynamic, tdmData);
        PrintTestSpecsSteps.printTestSpecs(testData);
	}
	
}
