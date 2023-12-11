package com.core.products;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.automation.framework.ScriptHelper;
import com.aventstack.extentreports.Status;
import com.reusable.Utils;


public class NewsAndFeaturesActions extends Utils
{
	public NewsAndFeaturesActions(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}
	
	List<String> totalFeedsDuration = new ArrayList<String>();
	
	/****************************************************************************************************
	 * This method will get total video feeds count available in the page
	 ***************************************************************************************************/
	public void getTotalVideoFeedsCount()
	{
		waitForPageToLoad();
		try 
		{
			List<WebElement> webElements = getWebElements(NewsAndFeaturesPageObjects.feedDuration);
			for (WebElement webElement : webElements) 
			{
				totalFeedsDuration.add(webElement.getText());
			}
			report.log(Status.PASS, "Total no. of Video feeds in News and Features page are "+totalFeedsDuration.size());
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}
	
	/****************************************************************************************************
	 * This method will get total Video feeds which are more than given number of days old
	 * @param noOfDays
	 ***************************************************************************************************/
	public void getTotalVideoFeedsMoreThanDaysCount(int noOfDays)
	{
		try 
		{
			List<String> videoFeedsMoreThanDays = new ArrayList<String>();
			for (String videoFeed : totalFeedsDuration) 
			{
				if(Character.getNumericValue(videoFeed.trim().charAt(0)) >=noOfDays)
				{
					videoFeedsMoreThanDays.add(videoFeed);
				}
			}
			report.log(Status.PASS, "Total no. of Video feeds in News and Features page that are more than "+noOfDays+" days are "+videoFeedsMoreThanDays.size());
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}

}
