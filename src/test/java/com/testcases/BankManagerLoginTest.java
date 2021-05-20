package com.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void bankManagerLogin() throws InterruptedException {
		
		
		driver.get(config.getProperty("baseUrl"));
		log.info("loaded URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		log.info("clicked on bank manager login button");
		Thread.sleep(1000);
		
		Assert.assertTrue(isElementPresnt(By.cssSelector(or.getProperty("addCustomerBtn"))), "login was not successfull");
log.info("login success");


	}

}


