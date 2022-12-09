package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Amazonpages;
import com.qa.utility.ExcelUtility;

public class Amazonsearch extends Testbase
{

	@DataProvider(name="data")
	public String[][] getData() throws IOException {
		
		String xFile="C:\\Users\\Bhavankumar\\eclipse-workspace\\Amazontest\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheet="Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;

}
	@Test(dataProvider = "data")
	public void test_001(String category,String itemname) throws InterruptedException {
	
		Amazonpages.Categories.click();
		Select select = new Select(Amazonpages.Categories);
		select.selectByVisibleText(category);
		Amazonpages.SearchBox.sendKeys(itemname+Keys.ENTER);
		Amazonpages.SearchBox.clear();
		if(Driver.getTitle().contains(itemname)) {
		System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
	}
	
}