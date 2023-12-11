package com.core.products;

import org.openqa.selenium.By;

public class CoreProductsHomePageObjects 
{
	
	public static final By shopSection = By.xpath("//li/a/span[text()='Shop']");
	public static final By mensOption = By.xpath("//li/a/span[text()='Shop']/../following-sibling::nav//a[text()=\"Men's\"]");
	
	public static final By additionalMenuSection = By.xpath("//nav[contains(@class,'headerSecondaryMenu')]//li[@data-testid='nav-item-#']/a");
	public static final By newsAndFeatures = By.xpath("//nav[contains(@class,'headerSecondaryMenu')]//a[@title='News & Features']");

	public static final By alertCloseButton = By.xpath("//div[@role='dialog']//div[text()='x']");
	
}
