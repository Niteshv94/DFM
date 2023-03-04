/**
 * 
 */
package com.dfm.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dfm.base.BaseClass;
import com.dfm.pages.AccountPageAdmin;
import com.dfm.pages.HomePageAdmin;
import com.dfm.pages.HomePageUser;
import com.dfm.pages.LoginPageAdmin;
import com.dfm.pages.LoginPageUser;
import com.dfm.pages.TagExplorer;
import com.dfm.utility.ExcelDataProvider;

/**
 * @author Nitesh
 *
 */

public class HomeAdmin_01 extends BaseClass {

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void createCustomer() throws InterruptedException {

		logger = extentReports.createTest("Entering Customer Details");

		HomePageAdmin homePageAdmin = PageFactory.initElements(driver, HomePageAdmin.class);

		logger.info("Customer Details Entered");

		homePageAdmin.clickOnHamburgerIcon();

		homePageAdmin.clickOnCreateCustomer(excelDataProvider.getStringData("AddCustomerAdmin", 1, 0),
				excelDataProvider.getStringData("AddCustomerAdmin", 1, 2));

		logger.pass("Customer Details Entered & Added Successfully");

	}

	@Test(priority = 3)
	public void searchUserDetails() throws InterruptedException {

		logger = extentReports.createTest("Enter & Search User");

		HomePageAdmin homePageAdmin = PageFactory.initElements(driver, HomePageAdmin.class);

		logger.info("Enter & Search User");

		Thread.sleep(5000);
		homePageAdmin.searchUser(excelDataProvider.getStringData("searchUserName", 1, 0));

		logger.pass("User Searched Successfully");

	}

	@DataProvider
	public Iterator<Object[]> getUserData() {
		ArrayList<Object[]> testdata = ExcelDataProvider.getUserDataFromExcel();
		return testdata.iterator();
	}

	@Test(priority = 4, dataProvider = "getUserData")
	public void addUserDetails(String firstName, String lastName, String email, String type)
			throws InterruptedException {

		logger = extentReports.createTest("Navigate to Add User Section");

//		//HomePageAdmin homePageAdmin = PageFactory.initElements(driver, HomePageAdmin.class);
		AccountPageAdmin accountPageAdmin = PageFactory.initElements(driver, AccountPageAdmin.class);

		logger.info("Enter Details & Add User");

		accountPageAdmin.addUser1(excelDataProvider.getStringData("UserDetails", 1, 0),
				excelDataProvider.getStringData("UserDetails", 1, 1),
				excelDataProvider.getStringData("UserDetails", 1, 2),
				excelDataProvider.getStringData("UserDetails", 1, 3));

		accountPageAdmin.addUser2(excelDataProvider.getStringData("UserDetails", 2, 0),
				excelDataProvider.getStringData("UserDetails", 2, 1),
				excelDataProvider.getStringData("UserDetails", 2, 2),
				excelDataProvider.getStringData("UserDetails", 2, 3));

		accountPageAdmin.addUser3(excelDataProvider.getStringData("UserDetails", 3, 0),
				excelDataProvider.getStringData("UserDetails", 3, 1),
				excelDataProvider.getStringData("UserDetails", 3, 2),
				excelDataProvider.getStringData("UserDetails", 3, 3));

		accountPageAdmin.addUser4(excelDataProvider.getStringData("UserDetails", 4, 0),
				excelDataProvider.getStringData("UserDetails", 4, 1),
				excelDataProvider.getStringData("UserDetails", 4, 2),
				excelDataProvider.getStringData("UserDetails", 4, 3));

		accountPageAdmin.addUser5(excelDataProvider.getStringData("UserDetails", 5, 0),
				excelDataProvider.getStringData("UserDetails", 5, 1),
				excelDataProvider.getStringData("UserDetails", 5, 2),
				excelDataProvider.getStringData("UserDetails", 5, 3));

		logger.pass("User Added Successfully");

	}

	@DataProvider
	public Iterator<Object[]> getNewlyUserCreatedData() {
		ArrayList<Object[]> testdata = ExcelDataProvider.getNewUserDataFromExcel();
		return testdata.iterator();
	}

	@Test(priority = 5, dataProvider = "getNewlyUserCreatedData")
	public void checkNewUserLoginAndLogout(String username, String password) throws InterruptedException {

		logger = extentReports.createTest("Perform Login & Logout with New User");

		Thread.sleep(5000);

		driver.get("https://qa.modeler2.decisionsfirst.com/login");

		Thread.sleep(4000);

		HomePageUser homePageUser = PageFactory.initElements(driver, HomePageUser.class);
		LoginPageUser loginPageUser = PageFactory.initElements(driver, LoginPageUser.class);

		logger.info("Login & Logout with New User");

		loginPageUser.loginToDfmUserAccount(excelDataProvider.getStringData("newlyCreatedUserDetails", 1, 0),
				excelDataProvider.getStringData("newlyCreatedUserDetails", 1, 1));
		Thread.sleep(15000);
		homePageUser.clickOnLoglout();

		loginPageUser.loginToDfmUserAccount(excelDataProvider.getStringData("newlyCreatedUserDetails", 2, 0),
				excelDataProvider.getStringData("newlyCreatedUserDetails", 2, 1));
		Thread.sleep(8000);
		homePageUser.clickOnLoglout();

		loginPageUser.loginToDfmUserAccount(excelDataProvider.getStringData("newlyCreatedUserDetails", 3, 0),
				excelDataProvider.getStringData("newlyCreatedUserDetails", 3, 1));
		Thread.sleep(8000);
		homePageUser.clickOnLoglout();

		loginPageUser.loginToDfmUserAccount(excelDataProvider.getStringData("newlyCreatedUserDetails", 4, 0),
				excelDataProvider.getStringData("newlyCreatedUserDetails", 4, 1));
		Thread.sleep(8000);
		homePageUser.clickOnLoglout();

		logger.pass("Login & Logout with New User checked Successfully");

	}

	@Test (priority = 6)
	public void addProject() throws InterruptedException {

		logger = extentReports.createTest("Enter Project Name");

		LoginPageUser loginPageUser = PageFactory.initElements(driver, LoginPageUser.class);
		HomePageUser  homePageUser = PageFactory.initElements(driver, HomePageUser.class);
		TagExplorer tagExplorer = PageFactory.initElements(driver, TagExplorer.class);

		logger.info("Enter Project Name");
		
		loginPageUser.loginToDfmUserAccount(excelDataProvider.getStringData("newlyCreatedUserDetails", 1, 0),
				excelDataProvider.getStringData("newlyCreatedUserDetails", 1, 1));
		
		homePageUser.clickOnTagExplorer();
		
		tagExplorer.clickOnProjectTagsPlusSymbol();
		
		tagExplorer.enterProjectnameDescriptionAndClickOnRadiobutton(excelDataProvider.getStringData("ProjectName", 1, 0),
				excelDataProvider.getStringData("ProjectName", 1, 1));
		
		logger.pass("Project Name created Successfully");

	}
}
