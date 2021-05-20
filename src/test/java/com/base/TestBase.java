
package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.ExcelReader;
import com.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(TestBase.class);
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Data.xlsx");
    public ExtentReports rep=ExtentManager.getInstance();
    public static ExtentTest test;
    
   

	@BeforeSuite
	public void setup() {

		if (driver == null) {

			try {

				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
				log.info("properties file Input stream object created");
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				config.load(fis);

				log.info("loaded the config properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.properties");
						

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				or.load(fis);

				log.info("loaded the or properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

				log.info("chrome browser launched");

			} else if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();

				driver = new FirefoxDriver();

				log.info("firefox browser launched");

			} else if (config.getProperty("browser").equals("ie")) {
				WebDriverManager.iedriver().setup();

				driver = new InternetExplorerDriver();
				log.info("IE browser launched");

			}

		}

	}

	public Boolean isElementPresnt(By by) {

		try {
			
			driver.findElement(by);
			
			return true;
			
		} catch (NoSuchElementException e) {
			
			
			log.error("Element not found"+e);
			return false;
		}

	}
	
	public void click(String locator) {
		
		driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		test.log(LogStatus.INFO, "clicking on :"+locator);
	}
	
	public void type(String locator,String value) {
		
	driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
	test.log(LogStatus.INFO , "typing in :"+value);
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
