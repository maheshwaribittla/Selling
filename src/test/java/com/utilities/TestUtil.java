package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;


public class TestUtil extends TestBase {
	
	public static String screenShotName;
	
	public static void captureScreenshot() throws IOException {
		
		Date d=new Date();
		screenShotName=d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		
		
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		
		
	}
	
	
	

	
	
	
	

}

