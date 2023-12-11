package com.stepdefinitions;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.automation.framework.DriverClass;
import com.automation.framework.Reports;
import com.automation.framework.ReusableLibrary;
import com.automation.framework.ScriptHelper;
import com.automation.framework.TestData;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	
	Reports reports = new Reports();
	DriverClass driverClass = new DriverClass();
	TestData testData = new TestData();
	
	ScriptHelper scriptHelper;
	String scenarioName;
	HashMap<String, String> testingData = new HashMap<String, String>();
	
	@Before
	public void setUp(Scenario scenario)
	{
		scenarioName = scenario.getName();
		testingData = testData.getTestData(scenarioName);
		driverClass.instantiateBrowser(testingData.get("BrowserName"));
		reports.createExtentReport(scenario.getName());
		
		scriptHelper = new ScriptHelper(driverClass, reports, testData, scenarioName);
		new ReusableLibrary(scriptHelper);
	}
	
	@After
	public void tearDown()
	{
		ExtentTest test = reports.getTestReport();
		reports.closeReport(test);
		driverClass.clearDriver();
	}

}
