package com.testcases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstName,String lastName,String postalCode) throws InterruptedException {
		
		driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn"))).click();
		log.info("clicked on Add customer Button");
		driver.findElement(By.cssSelector(or.getProperty("firstNameTextBox"))).sendKeys(firstName);
		log.info("Entered First Name: "+firstName);
		driver.findElement(By.cssSelector(or.getProperty("lastNameTextBox"))).sendKeys(lastName);
		log.info("Entered last Name: "+lastName);
	    driver.findElement(By.cssSelector(or.getProperty("postalCodeTextBox"))).sendKeys(postalCode);
	    log.info("Entered postal code: " +postalCode);
	    driver.findElement(By.cssSelector(or.getProperty("addedCustomerBtn"))).click();
	    log.info("customer added");
	    Thread.sleep(3000);
	    Alert  alert=driver.switchTo().alert();
	    alert.accept();
	}

	@DataProvider
	public Object[][] getData() {
		
		String sheetName="addCustomerTest";
		int rowCount=excel.getRowCount(sheetName);
		log.info("Excel Row Size is"+rowCount);
		int colCount=excel.getColumnCount(sheetName);
		log.info("Excel column Size is"+colCount);
		Object[][] data=new Object[rowCount-1][colCount];
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			for(int colNum=0;colNum<colCount;colNum++) {
		
		data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
		
			}
		}
		return data;
	}
}