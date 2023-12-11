package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/CoreProduct.feature"}, glue = {"com.stepdefinitions"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests
{
	

}
