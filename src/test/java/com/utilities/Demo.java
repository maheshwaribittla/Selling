package com.utilities;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d.toString().replace(" ", "_").replace(":", "_"));
		}
	}


