package com.stepdefinitions;

import com.automation.framework.ReusableLibrary;
import com.automation.framework.ScriptHelper;
import com.core.products.CoreProductsShopActions;
import com.core.products.MensPageActions;
import com.core.products.MensPageObjects;
import com.core.products.NewsAndFeaturesActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoreProductsStepDefinition 
{
	ScriptHelper scriptHelper = ReusableLibrary.scriptHelper;
	CoreProductsShopActions cpActions = new CoreProductsShopActions(scriptHelper);
	MensPageActions mpActions = new MensPageActions(scriptHelper);
	NewsAndFeaturesActions nfActions = new NewsAndFeaturesActions(scriptHelper);

	@Given("^User is on Core Products Home page$")
	public void navigateToCoreProductsHomePage()
	{
		cpActions.openURL();
	}
	
	@Given("^User hovers on Shop section$")
	public void navigateToShopSection()
	{
		cpActions.hoverOnShopSection();
	}
	
	@And("^User navigates to Mens section$")
	public void naviageToMensSection()
	{
		cpActions.clickOnMensOption();
	}
	
	@When("^User filters by Jackets$")
	public void filterByJackets()
	{
		mpActions.filterByJackets();
	}
	
	@Then("^User will fetch all jacket details$")
	public void fetchAllJacketDetails()
	{
		mpActions.getJacketDetails();
	}
	
	@And("^User writes those details to text file$")
	public void writeJacketDetailsToTextFile()
	{
		mpActions.appendJacketDetailsToTextFile();
	}
	
	@Given("^User hovers on Additional Menu section$")
	public void navigateToAdditionalMenu()
	{
		cpActions.hoverOnAdditionalMenuSection();
	}
	
	@When("^User navigates to News & Features section$")
	public void navigateToNewsAndFeaturesSection()
	{
		cpActions.clickOnNewsAndFeaturesOption();
	}
	
	@Then("^User fetches total Video feeds count$")
	public void fetchAllVideoFeedsCount()
	{
		nfActions.getTotalVideoFeedsCount();
	}
	
	@And("User will count Total Video Feeds more than {int} days")
	public void fetchVideoFeedsMoreThanDays(int noOfDays)
	{
		nfActions.getTotalVideoFeedsMoreThanDaysCount(noOfDays);
	}
	

}
