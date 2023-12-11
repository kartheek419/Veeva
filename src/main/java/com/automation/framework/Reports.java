package com.automation.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports 
{
	private ExtentReports reports;
	private ExtentTest test;
	
	/****************************************************************************************************
	 * This method will create Extent Reports for the given file name
	 * @param fileName
	 ***************************************************************************************************/
	public void createExtentReport(String fileName)
	{
		fileName = fileName + " reports.html";
//		extent = new ExtentReports();
		
		reports = new ExtentReports();
//		reports.createTest(fileName+" reports.html");
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setEncoding("utf-8");
		
		reports.attachReporter(reporter);
		
		test = reports.createTest(fileName);
		
			
	}
	
	/****************************************************************************************************
	 * This method will return reports object reference
	 * @return
	 ***************************************************************************************************/
	public ExtentReports getReports()
	{
		return reports;
	}
	
	/****************************************************************************************************
	 * This method will return extent test object reference
	 * @return
	 ***************************************************************************************************/
	public ExtentTest getTestReport()
	{
		return test;
	}
	
	/****************************************************************************************************
	 * This method will close the report for the given extent test object
	 * @param test
	 ***************************************************************************************************/
	public void closeReport(ExtentTest test)
	{
		reports.flush();
		reports.removeTest(test);
	}

}
