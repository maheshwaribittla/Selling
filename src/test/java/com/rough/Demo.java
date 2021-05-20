package com.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {
	
	
	public static void main(String args[]) throws IOException{
		
		
		String path=System.getProperty("user.dir");
		
		System.out.println(path);
		
		Properties config=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		
		config.load(fis);
		
		System.out.println(config.getProperty("browser"));
		
		
		Properties or=new Properties();
		FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.properties");
         or.load(fis1);
		System.out.println(or.getProperty("usname"));

		
	}

}


