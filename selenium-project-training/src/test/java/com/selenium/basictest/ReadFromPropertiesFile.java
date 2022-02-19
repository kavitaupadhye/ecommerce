package com.selenium.basictest;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

	public static void main(String[] args) throws Exception {

		String propertiesFilePath=System.getProperty("user.dir")+"\\Config\\config.properties";
		FileInputStream fin=new FileInputStream(propertiesFilePath);
		
		Properties p=new Properties();
		p.load(fin);
		
		String url=p.getProperty("url");
		String br=p.getProperty("browser");
		
		System.out.println(url);
		System.out.println(br);
		fin.close();
		
	}

}
