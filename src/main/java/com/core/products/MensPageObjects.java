package com.core.products;

import org.openqa.selenium.By;

public class MensPageObjects 
{
	
	public static final By jacketsOption = By.xpath("//div[contains(@class,'allDepartmentsBoxes')]//a/span[text()='Jackets']");
	
	public static final By eachResultSection = By.xpath("//div[@class='product-card row']");
	public static final By eachResultPrice = By.xpath("//div[@class='price-row']/span[@class='lowest']//span[@class='sr-only']");
	public static final By eachResultTitle = By.xpath("//div[@class='product-card row']//div[@class='product-card-title']/a");
	public static final By eachResultTopSellerMessagePrefix = By.xpath("//div[contains(@class,'top-seller-vibrancy')]/span/span[@class='top-seller-vibrancy-message']");
	public static final By eachResultTopSellerMessage = By.xpath("//div[contains(@class,'top-seller-vibrancy')]/span/span[@class='top-seller-vibrancy-message hide-for-small-only']");
	
	public static final By nextPage = By.xpath("//div[@class='product-grid-bottom-area']//li[@class='next-page']/a");
	public static final By nextPagedisabled = By.xpath("//div[@class='product-grid-bottom-area']//li[@class='next-page disabled']/a");
	
	
}
