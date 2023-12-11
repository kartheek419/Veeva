package com.automation.framework;



import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

public class ScriptHelper 
{
	
	protected ExtentTest extentTest;
	protected WebDriver driver;
	protected HashMap<String, String> testingData;
	
	public ScriptHelper(DriverClass driverClass, Reports reports, TestData testData, String testCaseName)
	{
		this.driver = driverClass.getWebDriver();
		this.extentTest = reports.getTestReport();
		this.testingData = testData.getTestData(testCaseName);		
	}

}
