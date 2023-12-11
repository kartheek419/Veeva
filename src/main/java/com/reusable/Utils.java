package com.reusable;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.ReusableLibrary;
import com.automation.framework.ScriptHelper;

public class Utils extends ReusableLibrary
{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement wb;
	Actions action = new Actions(driver);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	protected Utils(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}
	
	/*********************************************************************************************
	 * This method will explicitly wait for the element to present for max 30 seconds
	 * @param byElement
	 ********************************************************************************************/
	public void waitFor(By byElement)
	{
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	
	/*********************************************************************************************
	 * This method will open the url and will wait for the page to load completely
	 ********************************************************************************************/
	public void openURL()
	{
		String url = data.get("URL");
		try 
		{
			driver.get(url);
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	/**********************************************************************************************
	 * This method click on the given element
	 * @param byElement - By reference element to be clicked
	 ********************************************************************************************/
	public void click(By byElement)
	{
		wb = getWebElement(byElement);
		waitForElementToBeClickable(wb);
		try 
		{
			driver.findElement(byElement).click();
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method clicks on the given Web element
	 * @param wb - Web element to be clicked
	 ********************************************************************************************/
	public void click(WebElement wb)
	{
		waitForElementToBeClickable(wb);
		try 
		{
			wb.click();
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will fetch the text from browser for given element
	 * @param byElement - by reference element
	 * @return - fetched text
	 ********************************************************************************************/
	public String getText(By byElement)
	{
		waitForElementToBeVisible(byElement);
		
		try 
		{
			String text = driver.findElement(byElement).getText();
			return text;
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will fetch the text from the given web element
	 * @param wb - Web element
	 * @return - fetched text
	 ********************************************************************************************/
	public String getText(WebElement wb)
	{
		waitForElementToBeVisible(wb);
		try 
		{
			String text = wb.getText();
			return text;
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will fetch the given text based on given base web element instead of web driver
	 * @param baseElement - Base web element
	 * @param byElement - by reference element
	 * @return - fetched text
	 ********************************************************************************************/
	public String getText(WebElement baseElement, By byElement)
	{
		waitForElementToBeVisible(byElement);
		String text = "";
		
		try 
		{
			text = baseElement.findElement(byElement).getText();
		} 
		catch (Exception e) 
		{
			throw e;
		}
		return text;
		
	}
	
	/*********************************************************************************************
	 * 	This method will return the web element for the given by reference element
	 * @param byElement - by reference element
	 * @return - web element
	 ********************************************************************************************/
	public WebElement getWebElement(By byElement)
	{
		try 
		{
			wb=driver.findElement(byElement);
			return wb;
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will return the list of web elements for the given by reference element
	 * @param byElement - by reference element
	 * @return - list of web elements
	 ********************************************************************************************/
	public List<WebElement> getWebElements(By byElement)
	{
		try 
		{
			List<WebElement> webElements = driver.findElements(byElement);
			return webElements;
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will perform action of mouse hover on given by reference element
	 * @param byElement - by reference element
	 ********************************************************************************************/
	public void mouseHover(By byElement)
	{
		waitFor(byElement);
		wb = getWebElement(byElement);
		try 
		{
			action.moveToElement(wb).perform();
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/******************************************************************************************************************
	 * This method will scroll to the given element and then a little upwards so that the element is in visible rage
	 * @param wb - web element
	 ******************************************************************************************************************/
	public void scrolltoElement(WebElement wb)
	{
		try 
		{
			jse.executeScript("arguments[0].scrollIntoView(true)", wb );
			jse.executeScript("window.scrollTo(0,-50)" );
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/******************************************************************************************************************
	 * This method will scroll to the given element and then a little upwards so that the element is in visible rage
	 * @param byElement - by reference element
	 *******************************************************************************************************************/
	public void scrolltoElement(By byElement)
	{
		wb = getWebElement(byElement);
		try 
		{
			jse.executeScript("arguments[0].scrollIntoView(true)", wb );
			jse.executeScript("window.scrollTo(0,-50)" );
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method gets the reference of current window
	 * @return - string reference of current window
	 ********************************************************************************************/
	public String getCurrentWindow()
	{
		return driver.getWindowHandle();
	}
	
	/*********************************************************************************************
	 * This method gets references of all open windows 
	 * @return - Set of string reference of all open windows
	 ********************************************************************************************/
	public Set<String> getAllWindows()
	{
		return driver.getWindowHandles();
	}
	
	/*********************************************************************************************
	 * This method will switch to the given window reference
	 * @param window - window reference
	 ********************************************************************************************/
	public void switchToWindow(String window)
	{
		try 
		{
			driver.switchTo().window(window);
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will create a text file if not available and then append text to it		
	 * @param fileName - Text file name
	 * @param textToBeAdded - Text to be appended
	 * @throws Exception
	 ********************************************************************************************/
	public void appendToTextFile(String fileName, String textToBeAdded) throws Exception
	{
		File file = new File(fileName);
		if(!file.exists())
			file.createNewFile();
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(textToBeAdded);
		fw.write(System.lineSeparator());
		fw.close();
	}
	
	/*********************************************************************************************
	 * This method will verify if the given element is enabled or not. 
	 * @param byElement - by reference element
	 * @return - will return true if found, else false
	 ********************************************************************************************/
	public boolean isEnabled(By byElement)
	{
		try 
		{
			scrolltoElement(byElement);
			return driver.findElement(byElement).isEnabled();
		} 
		catch (Exception e) 
		{
			return false;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will wait for the element to be visible
	 * @param byElement - by reference element
	 ********************************************************************************************/
	public void waitForElementToBeVisible(By byElement)
	{
		try 
		{
			scrolltoElement(byElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will wait for the element to be visible
	 * @param wb - web element
	 ********************************************************************************************/
	public void waitForElementToBeVisible(WebElement wb)
	{
		try 
		{
			scrolltoElement(wb);
			wait.until(ExpectedConditions.visibilityOf(wb));
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will wait for the element to be clickable
	 * @param byElement - by reference element
	 ********************************************************************************************/
	public void waitForElementToBeClickable(By byElement)
	{
		try 
		{
			scrolltoElement(byElement);
			wait.until(ExpectedConditions.elementToBeClickable(byElement));
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will wait for the element to be clickable
	 * @param wb - web element
	 ********************************************************************************************/
	public void waitForElementToBeClickable(WebElement wb)
	{
		try 
		{
			scrolltoElement(wb);
			wait.until(ExpectedConditions.elementToBeClickable(wb));
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	/*********************************************************************************************
	 * This method will close all the unwanted popup at the time of page opening
	 * @param byElement - by reference element
	 ********************************************************************************************/
	public void clearCache(By byElement)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(byElement));
			click(byElement);
		}
		catch (Exception e) 
		{
		
		}
		
	}
	
	/*********************************************************************************************
	 * This element waits for the page to load completely
	 ********************************************************************************************/
	public void waitForPageToLoad()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>)
				driver ->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
	
	

}
