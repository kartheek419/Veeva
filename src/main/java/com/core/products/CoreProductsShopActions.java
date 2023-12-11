package com.core.products;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.automation.framework.ScriptHelper;
import com.aventstack.extentreports.Status;
import com.reusable.Utils;

public class CoreProductsShopActions extends Utils
{

	protected String jacketDetails="";
	public CoreProductsShopActions(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}
	
	
	/****************************************************************************************************
	 * This method will hover on the Shop section in home page
	 ***************************************************************************************************/
	public void hoverOnShopSection()
	{
		clearCache(CoreProductsHomePageObjects.alertCloseButton);
		try 
		{
			mouseHover(CoreProductsHomePageObjects.shopSection);
			report.log(Status.PASS, "Successfully hovered on Shop section.");
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed to hover on Shop section"+e.getMessage());
			assertFalse(true);
		}
	}
	
	/****************************************************************************************************
	 * This method will hover on the additional menu section in home page
	 ***************************************************************************************************/
	public void hoverOnAdditionalMenuSection()
	{
		clearCache(CoreProductsHomePageObjects.alertCloseButton);
		try 
		{
			mouseHover(CoreProductsHomePageObjects.additionalMenuSection);
			report.log(Status.PASS, "Successfully hovered on Additional Menu section.");
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed to hover on Additional Menu section"+e.getMessage());
			assertFalse(true);
		}
	}
	
	
	/****************************************************************************************************
	 * This method will click on the Men's Option
	 ***************************************************************************************************/
	public void clickOnMensOption()
	{
		try 
		{
			click(CoreProductsHomePageObjects.mensOption);
			report.log(Status.PASS, "Successfully clicked on Men's option.");
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed to click on Men's option"+e.getMessage());
			assertFalse(true);
		}
		
	}
	
	/****************************************************************************************************
	 * This method will click on the News and Features option
	 ***************************************************************************************************/
	public void clickOnNewsAndFeaturesOption()
	{
		try 
		{
			click(CoreProductsHomePageObjects.newsAndFeatures);
			report.log(Status.PASS, "Successfully clicked on New & Features option.");
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed to click on New & Features option"+e.getMessage());
			assertFalse(true);
		}
		
	}
	
	
}
