package com.automation.framework;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass 
{
	private WebDriver driver;
	
	/****************************************************************************************************
	 * This method will initiate the browser for the given browser name
	 * @param browserName
	 ***************************************************************************************************/
	public void instantiateBrowser(String browserName)
	{
		
		Map prefs = new HashMap();
		switch (browserName.toLowerCase()) 
		{
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				prefs.put("profile.default_content_settings.cookies", 2);
				ChromeOptions browseroptions = new ChromeOptions();
				browseroptions.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(browseroptions);
				
				break;
			case "firefox":
				
				
				WebDriverManager.firefoxdriver().setup();
				prefs.put("profile.default_content_settings.cookies", 2);
				FirefoxOptions firefoxOptions = new FirefoxOptions(); 
				driver = new FirefoxDriver(firefoxOptions);
				
				break;
	
			default:
				
				System.out.println("Please enter a valid browser name");
				
				break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/****************************************************************************************************
	 * This method will retrieve the web driver reference
	 * @return
	 ***************************************************************************************************/
	public WebDriver getWebDriver()
	{
		return this.driver;
	}
	
	/****************************************************************************************************
	 * This method will close the browser session
	 ***************************************************************************************************/
	public void clearDriver()
	{
		this.driver.quit();
		this.driver = null;
	}

}
