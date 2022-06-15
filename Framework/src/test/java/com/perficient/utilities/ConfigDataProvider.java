package com.perficient.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties property;
	public ConfigDataProvider()
	{
		File fi = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(fi);
			
			property = new Properties();
			
			property.load(fis);
		} 
		catch (Exception e) 
		{
		  System.out.println("Not able to load config file!!"+e.getMessage());	
        }
		
	}
	 
	public String getDataFromConfig(String keyToSearch)
	{
		return property.getProperty(keyToSearch);
	}
	
	
	public String getBrowser()
	{
		return property.getProperty("Browser");
	}
	
	public String getProdURL()
	{
		return property.getProperty("ProdUrl");
	}

}
