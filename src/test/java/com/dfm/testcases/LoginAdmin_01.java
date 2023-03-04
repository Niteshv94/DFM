/**
 * 
 */
package com.dfm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dfm.base.BaseClass;
import com.dfm.pages.LoginPageAdmin;

/**
 * @author Nitesh
 *
 */
public class LoginAdmin_01 extends BaseClass {

	@Test
	public void loginAction() {

		logger = extentReports.createTest("Login to DFM");

		System.out.println("The title of the Application is : " + driver.getTitle());

		System.out.println("The CurrentUrl of the Application is : " + driver.getCurrentUrl());

		LoginPageAdmin loginPageAdmin = PageFactory.initElements(driver, LoginPageAdmin.class);

		logger.info("Starting Application");

		loginPageAdmin.loginToDfm(excelDataProvider.getStringData("LoginPageAdmin", 1, 0),
				excelDataProvider.getStringData("LoginPageAdmin", 1, 1));

		logger.pass("Login Success");

	}

}