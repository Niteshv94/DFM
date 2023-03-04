/**
 * 
 */
package com.dfm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Nitesh
 *
 */
public class AccountPageAdmin {

	WebDriver driver;

	public AccountPageAdmin(WebDriver localDriver) {
		this.driver = localDriver;
	}

//	@FindBy(xpath = "//span[contains(text(),'Mpho Testing account 2022')]")
//	WebElement customer_Account_Menu;

	@FindBy(xpath = "//button[normalize-space()='Add User']")
	WebElement button_Add_User;

	@FindBy(xpath = "//*[@id='firstName']/quill-editor/div[2]/div[1]")
	WebElement first_Name;

	@FindBy(xpath = "//*[@id='lastName']/quill-editor/div[2]/div[1]")
	WebElement last_Name;

	@FindBy(xpath = "//*[@id='email']/quill-editor/div[2]/div[1]")
	WebElement user_emailId;

	@FindBy(xpath = "//select[@class='form-control ng-untouched ng-pristine ng-valid']")
	WebElement dropdown_type;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Add User']")
	WebElement button_Add_User1;

	// Enter User Details Method
	public void addUser1(String firstName, String lastName, String email, String type) throws InterruptedException

	{
		Thread.sleep(3000);
		button_Add_User.click();

		first_Name.sendKeys(firstName);

		last_Name.sendKeys(lastName);

		user_emailId.sendKeys(email);

		Select select = new Select(dropdown_type);
		select.selectByValue(type);

		button_Add_User1.click();
	}

	// Enter User2 Details Method
	public void addUser2(String firstName, String lastName, String email, String type) throws InterruptedException

	{
		Thread.sleep(3000);
		button_Add_User.click();

		first_Name.sendKeys(firstName);

		last_Name.sendKeys(lastName);

		user_emailId.sendKeys(email);

		Select select = new Select(dropdown_type);
		select.selectByValue(type);

		button_Add_User1.click();
	}

	// Enter User3 Details Method
	public void addUser3(String firstName, String lastName, String email, String type) throws InterruptedException

	{
		Thread.sleep(3000);
		button_Add_User.click();

		first_Name.sendKeys(firstName);

		last_Name.sendKeys(lastName);

		user_emailId.sendKeys(email);

		Select select = new Select(dropdown_type);
		select.selectByValue(type);

		button_Add_User1.click();
	}

	// Enter User4 Details Method
	public void addUser4(String firstName, String lastName, String email, String type) throws InterruptedException

	{
		Thread.sleep(3000);
		button_Add_User.click();

		first_Name.sendKeys(firstName);

		last_Name.sendKeys(lastName);

		user_emailId.sendKeys(email);

		Select select = new Select(dropdown_type);
		select.selectByValue(type);

		button_Add_User1.click();
	}

	// Enter User5 Details Method
	public void addUser5(String firstName, String lastName, String email, String type) throws InterruptedException

	{
		Thread.sleep(3000);
		button_Add_User.click();

		first_Name.sendKeys(firstName);

		last_Name.sendKeys(lastName);

		user_emailId.sendKeys(email);

		Select select = new Select(dropdown_type);
		select.selectByValue(type);

		button_Add_User1.click();
	}

}
