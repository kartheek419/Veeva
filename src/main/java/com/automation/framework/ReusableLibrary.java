package com.automation.framework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ReusableLibrary 
{
	
	public static ScriptHelper scriptHelper;
	protected WebDriver driver;
	protected ExtentTest report;
	public HashMap<String, String> data;
	
	public ReusableLibrary(ScriptHelper scriptHelper)
	{
		this.scriptHelper = scriptHelper;
		this.report = scriptHelper.extentTest;
		this.driver = scriptHelper.driver;
		this.data = scriptHelper.testingData;	
	}
	
	
}
