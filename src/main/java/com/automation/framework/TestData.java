package com.automation.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData 
{
	HashMap<String, String> testData= new HashMap<String, String>();
	XSSFWorkbook wb = null;
	
	/*********************************************************************************************
	 * This method will fetch the test data from the excel sheet
	 * @param senarioName - name of the column 
	 * @return - return hashmap 
	 ********************************************************************************************/
	public HashMap<String, String> getTestData(String senarioName)
	{
		
		XSSFSheet sheet = getWorkbookSheet();
		int noOfRows = sheet.getLastRowNum();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		for(int rowNum=1; rowNum<= noOfRows; rowNum++)
		{
			if(sheet.getRow(rowNum).getCell(0).getStringCellValue().equals(senarioName))
			{
				for(int colNum=0;colNum<noOfColumns;colNum++)
				{
					testData.put(sheet.getRow(0).getCell(colNum).getStringCellValue(), sheet.getRow(rowNum).getCell(colNum).getStringCellValue());
				}
				break;
				
			}
		}
		closeWorkbook();
		return testData;
	}
	
	/*********************************************************************************************
	 * This mtehod will return the sheet for the given workbook
	 * @return - XSSF sheet
	 ********************************************************************************************/
	private XSSFSheet getWorkbookSheet()
	{
		File file = new File("src/test/resources//TestData/TestData.xlsx");
		FileInputStream fis;
		
		try 
		{
			fis = new FileInputStream(file);
			try 
			{
				wb = new XSSFWorkbook(fis);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return wb.getSheet("TestData");
	}
	
	/***************************************************************************************************
	 * This method will close the workbook after its usage
	 ***************************************************************************************************/
	private void closeWorkbook()
	{
		try 
		{
			wb.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
