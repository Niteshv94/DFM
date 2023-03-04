/**
 * 
 */
package com.dfm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Nitesh
 *
 */
public class LoginPageUser {

	WebDriver driver;

	public LoginPageUser(WebDriver localDriver) {
		this.driver = localDriver;
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement textBox_UserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement textBox_Password;

	@FindBy(xpath = "//div[@class='link']")
	WebElement link_ForgotPassword;

	@FindBy(xpath = "//button[@class='btn form-control btn-info mr-2 login-btn']")
	WebElement button_Login;

	public void loginToDfmUserAccount(String username, String password) throws InterruptedException {

		textBox_UserName.sendKeys(username);

		textBox_Password.sendKeys(password);
		
		//Thread.sleep(4000);

		button_Login.click();
	}

}
