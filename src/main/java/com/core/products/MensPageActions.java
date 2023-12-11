package com.core.products;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.automation.framework.ScriptHelper;
import com.aventstack.extentreports.Status;
import com.reusable.Utils;

public class MensPageActions extends Utils 
{

	public MensPageActions(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}
	protected String jacketDetails="";
	
	/****************************************************************************************************
	 * This method will select the filter - Jackets option
	 ***************************************************************************************************/
	public void filterByJackets()
	{
		try 
		{
			String currentWindow = getCurrentWindow();
			Set<String> allWindows = getAllWindows();
			for(String eachWindow: allWindows)
			{
				if(!eachWindow.equals(currentWindow))
				{
					switchToWindow(eachWindow);
				}
			}
		} 
		catch (Exception e) 
		{
			
		}
		clearCache(CoreProductsHomePageObjects.alertCloseButton);
		try 
		{
			click(MensPageObjects.jacketsOption);
			report.log(Status.PASS, "Successfully selected Jackets filter.");
			waitForPageToLoad();
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed to select Jackets filter"+e.getMessage());
			assertFalse(true);
		}
		
	}
	
	/****************************************************************************************************
	 * This method will get the jacket details from the page
	 ***************************************************************************************************/
	public void getJacketDetails()
	{
		List<WebElement> jacketsList = new ArrayList<WebElement>();
		
		
		do
		{
			
			try 
			{
				jacketsList = getWebElements(MensPageObjects.eachResultSection);
			} 
			catch (Exception e) 
			{
				report.log(Status.PASS, "Failed to fetch results list for Jackets"+e.getMessage());
				assertFalse(true);
			}
			
			for(WebElement eachJacket : jacketsList)
			{
				String jacketPrice = "";
				String jacketTitle = "";
				String jacketTopSellerMessage = "";
				try 
				{
					jacketPrice = getText(eachJacket, MensPageObjects.eachResultPrice);
				} 
				catch (Exception e) 
				{
					report.log(Status.PASS, e.getMessage());
					assertFalse(true);
				}
				
				try 
				{
					jacketTitle = getText(eachJacket, MensPageObjects.eachResultTitle);
				} 
				catch (Exception e) 
				{
					report.log(Status.PASS, e.getMessage());
					assertFalse(true);
				}
				
				try 
				{
					jacketTopSellerMessage = getText(eachJacket, MensPageObjects.eachResultTopSellerMessagePrefix)+ " "+
							getText(eachJacket, MensPageObjects.eachResultTopSellerMessage);
				} 
				catch (Exception e) 
				{
					
				}
				jacketDetails = jacketDetails+System.lineSeparator()+jacketTitle+" - "+jacketPrice+ " - "+jacketTopSellerMessage;
				
			}
			if(isEnabled(MensPageObjects.nextPage))
			{
				click(MensPageObjects.nextPage);
				waitForPageToLoad();
			}
			else if (isEnabled(MensPageObjects.nextPagedisabled)) 
			{
				break;
			}
			
			
		}while(isEnabled(MensPageObjects.nextPage));
	}
	
	/****************************************************************************************************
	 * This method will append the text to the text fiel
	 ***************************************************************************************************/
	public void appendJacketDetailsToTextFile()
	{
		try 
		{
			appendToTextFile("JacketDetails.txt", jacketDetails);
			report.log(Status.PASS, "Added Jacket Details to text file successfully"+"<a href='JacketDetails.txt'>JacketDetails</a>");
		} 
		catch (Exception e) 
		{
			report.log(Status.FAIL, "Failed adding jacket details to text file"+System.lineSeparator()+e.getMessage());
		}
	}

}
