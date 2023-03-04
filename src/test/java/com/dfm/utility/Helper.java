/**
 * 
 */
package com.dfm.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author Nitesh
 *
 */
public class Helper {
	
	//Screenshot, alerts, frames, windows, sync issue, ;java script

	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/DFM_"+getCurrentDateTime()+ ".png";
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
			
			System.out.println("Screenshot captured");
			 
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot>>> " + e.getMessage());
		}
		
		return screenshotpath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return dateFormat.format(currentdate);
	}
	
}
	