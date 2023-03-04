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
public class HomePageAdmin {

	WebDriver driver;

	public HomePageAdmin(WebDriver localDriver) {
		this.driver = localDriver;
	}

	@FindBy(xpath = "//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']")
	WebElement icon_Hamburger_Menu;

	@FindBy(xpath = "//span[contains(text(),'Create')]")
	WebElement button_Create;

	@FindBy(xpath = "//span[contains(text(),'Implementation component icons')]")
	WebElement button_Implementation_Component_Icons;

	@FindBy(xpath = "//span[contains(text(),'Version Information')]")
	WebElement button_Version_Information;

	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement button_LogOut;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement textBox_Search;

	@FindBy(xpath = "//i[@class='btn btn-info eva eva-search-outline search-icon']")
	WebElement icon_Search;

	@FindBy(xpath = "//span[@class='item-name']")
	WebElement suggested_User_List_After_Search;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	WebElement button_Previous;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement button_Next;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
	WebElement textBox_Enter_Name;

	@FindBy(xpath = "//input[@id='numberOfUsers']")
	WebElement textBox_NumberOfUser;

	@FindBy(xpath = "//textarea[@id='domains']")
	WebElement textBox_Domains;

	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	WebElement button_Add_Customer;

	public void clickOnHamburgerIcon() {
		icon_Hamburger_Menu.click();
	}

	// Create Customer Method
	public void clickOnCreateCustomer(String name, String domains) throws InterruptedException

	{
		button_Create.click();

		textBox_Enter_Name.sendKeys(name);

		textBox_NumberOfUser.clear();

		textBox_NumberOfUser.sendKeys("10");

		textBox_Domains.sendKeys(domains);

		 button_Add_Customer.click();

	}

	// Enter in search box and search User Details Method
	public void searchUser(String userName) throws InterruptedException

	{
		textBox_Search.sendKeys(userName);
		
		Thread.sleep(4000);

		icon_Search.click();

		suggested_User_List_After_Search.click();
	}

}
