package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;

public class DeleteCustomer extends TestBase {

	@Test(dataProvider = "getData")
	public void DeleteCutomerTest(String custname) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(or.getProperty("customersBtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(or.getProperty("searchtextbox"))).sendKeys(custname);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(or.getProperty("DeleteButton"))).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(or.getProperty("searchtextbox"))).clear();
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "DeleteCustomer1";
		int rowCount = excel.getRowCount(sheetName);
		log.info("Excel Row Size is" + rowCount);
		int colCount = excel.getColumnCount(sheetName);
		log.info("Excel column Size is" + colCount);
		Object[][] data = new Object[rowCount - 1][colCount];
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			for (int colNum = 0; colNum < colCount; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}