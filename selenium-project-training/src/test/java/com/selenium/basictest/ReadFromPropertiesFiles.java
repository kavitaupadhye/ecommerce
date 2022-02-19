package com.selenium.basictest;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromPropertiesFiles {

	public static void main(String[] args)throws Exception {

       String projectPath=System.getProperty("user.dir");
       String configFilePath=projectPath+"\\Config\\config.properties";
       
		FileInputStream fin=new FileInputStream(configFilePath);
		
		Properties p=new  Properties();
		
		p.load(fin);
		
		String application_url=p.getProperty("url");
		String browser_name=p.getProperty("browser");
		
		System.out.println(application_url);
		System.out.println(browser_name);
		
		
		fin.close();

	}

}
