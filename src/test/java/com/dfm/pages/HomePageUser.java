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
public class HomePageUser {

	WebDriver driver;

	public HomePageUser(WebDriver localDriver) {
		this.driver = localDriver;
	}

	@FindBy(xpath = "//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']")
	WebElement icon_Hamburger_Menu;

	@FindBy(xpath = "//div[@class='item all-tags-tab']//span[contains(text(),'Tag Explorer')]")
	WebElement icon_Tag_Explorer;

	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement button_LogOut;

	public void clickOnTagExplorer() throws InterruptedException {
		
		icon_Hamburger_Menu.click();
		
		Thread.sleep(2000);

		icon_Tag_Explorer.click();
	}
	
	public void clickOnLoglout() throws InterruptedException {

		icon_Hamburger_Menu.click();
		
		Thread.sleep(2000);
		
		button_LogOut.click();
		
		//Thread.sleep(3000);
	}

}
