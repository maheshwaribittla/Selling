package com.testcases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;

public class OpenCustomerTest extends TestBase{
	
	@Test(dataProvider="getData")
	public void openCustomer(String Customer,String Currency) throws InterruptedException {
		
		driver.findElement(By.cssSelector(or.getProperty("openCustomerBtn"))).click();
		log.info("clicked on open customer Button");
		
WebElement custdrp=driver.findElement(By.cssSelector(or.getProperty("customerDropdown")));
		Select drp=new Select(custdrp);
	drp.selectByVisibleText(Customer);
	WebElement currencydrp=driver.findElement(By.cssSelector(or.getProperty("currencyDropdown")));
	Select drp1=new Select(currencydrp);
drp1.selectByVisibleText(Currency);	
driver.findElement(By.cssSelector(or.getProperty("processBtn"))).click();
Thread.sleep(3000);
Alert  alert=driver.switchTo().alert();
alert.accept();
	}



	//@DataProvider
	
	//public Object[][] getData(){
		//Object[][] data=new Object[2][3];
		
		
		
		//data[0][0]="meheshwari";
		//data[0][1]="bittla";
		//data[0][2]="000234";
		
		//data[1][0]="parameshwari";
		//data[1][1]="bittla";
		//data[1][2]="000234";
		//return data;
		//}


@DataProvider
public Object[][] getData() {
	
	String sheetName="openAccountTest";
	int rowCount=excel.getRowCount(sheetName);
	log.info("Excel Row Size is: "+rowCount);
	int colCount=excel.getColumnCount(sheetName);
	log.info("Excel column Size is: "+colCount);
	Object[][] data=new Object[rowCount-1][colCount];
	for(int rowNum=2;rowNum<=rowCount;rowNum++) {
		
		for(int colNum=0;colNum<colCount;colNum++) {
	
	data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
	
		}
	}
	return data;
}
}