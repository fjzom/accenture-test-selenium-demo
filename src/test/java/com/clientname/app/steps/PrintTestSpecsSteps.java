package com.clientname.app.steps;

import org.json.JSONObject;

public class PrintTestSpecsSteps {
	
	public static void printTestSpecs(JSONObject testData) {
        System.out.println(testData.getString("ban"));
		
	}

}
