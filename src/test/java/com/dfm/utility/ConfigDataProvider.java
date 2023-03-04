/**
 * 
 */
package com.dfm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nitesh
 *
 */
public class ConfigDataProvider {

	Properties properties;

	// This constructor will load the config file
	public ConfigDataProvider() {
		File file_source = new File("./Configuration/Config.properties");

		try {
			FileInputStream inputStream = new FileInputStream(file_source);

			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {

			System.out.println("Unable to load Configuration File>>> " + e.getMessage());

		}
	}

	// This method will return the data
	public String getDataFromConfig(String keyToSearch) 
	{
		return  properties.getProperty(keyToSearch);
	}

	public String getBrowser() 
	{
		return  properties.getProperty("Browser");

	}

	public String getAdminManagerAppUrl() 
	{
		return  properties.getProperty("DfmAccountManagerQaURL");
	}
	
	public String getUserAppUrl() 
	{
		return  properties.getProperty("DfmUserAccountQaURL");
	}
}