/**
 * 
 */
package com.dfm.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.IIOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.dfm.utility.ExcelDataProvider;
import com.dfm.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dfm.utility.BrowserFactory;
import com.dfm.utility.ConfigDataProvider;

/**
 * @author Nitesh
 *
 */
public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excelDataProvider;
	public ConfigDataProvider configDataProvider;
	public ExtentReports extentReports;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() throws FileNotFoundException {
		
		Reporter.log("<<<<<Setting up Reports & Test is getting ready>>>>>", true);
		excelDataProvider = new ExcelDataProvider();
		configDataProvider = new ConfigDataProvider();

		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/DFM_" + Helper.getCurrentDateTime() + ".html"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
		Reporter.log("<<<<<Setting Done - Test can be started>>>>>", true);
	}

	@BeforeClass
	public void setup() {
		
		Reporter.log("<<<<<Trying to start browser and getting Application ready>>>>>", true);
		
		driver = BrowserFactory.startApplication(driver, configDataProvider.getBrowser(),
				configDataProvider.getAdminManagerAppUrl());
		
		Reporter.log("<<<<<Browser and Application is up and running>>>>>", true);
	}

	@AfterClass
	public void tearDown() {
		// BrowserFactory.quitbrowser(driver);
	}

	// ITestResult is an interface and the "result" variable will contain all the
	// details
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		//Reporter.log("<<<<<Test is about to End>>>>>", true);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skiped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extentReports.flush();
		
		//Reporter.log("<<<<<Test Completed - Reports Generated>>>>>", true);
	}

}
