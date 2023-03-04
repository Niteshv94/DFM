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
public class TagExplorer {

	WebDriver driver;

	public TagExplorer(WebDriver localDriver) {
		this.driver = localDriver;
	}

	@FindBy(xpath = "/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-folders-tags-management-container/nb-card/div/div[1]/div/i")
	WebElement icon_AddImport_Project;

	@FindBy(xpath = "//div[contains(text(),'Add Project')]")
	WebElement dropdown_Add_Project;

	@FindBy(xpath = "//div[contains(text(),'Import Project')]")
	WebElement dropdown_Import_Project;

	@FindBy(xpath = "//core-edit-multiple-lines-control[@id='name']//p")
	WebElement textbox_ProjectName;

	@FindBy(xpath = "//core-edit-multiple-lines-control[@id='description']//p")
	WebElement textbox_Description;

	@FindBy(xpath = "//nb-radio[@id='item-enableSimpleBranching']//span[@class='text']")
	WebElement radiobutton_enableSimpleBranching;

	@FindBy(xpath = "//nb-radio[@id='item-disableBranching']//span[@class='text']")
	WebElement radiobutton_disableBranching;

	@FindBy(xpath = "//input[@id='search-ip']")
	WebElement searchbox_ProjectOrTags;

	@FindBy(xpath = "//div[@class='input-icons']//i[@class='btn btn-info eva eva-search-outline search-icon']")
	WebElement searchicon_ProjectOrTags;

	@FindBy(xpath = "//div[@class='wj-node wj-state-collapsed project-node']//span[contains(text(),'Madhavan V (main)')]")
	WebElement Project_Tags_Name;

	@FindBy(xpath = "//div[contains(text(),'Add Tag')]")
	WebElement menu_Add_Tag;

	@FindBy(xpath = "//core-edit-multiple-lines-control[@id='name']//div[@class='ql-editor ql-blank']")
	WebElement textbox_Tag_Name;

	@FindBy(xpath = "//core-edit-multiple-lines-control[@id='description']//div[@class='ql-editor ql-blank']")
	WebElement textbox_Tag_Description;

	@FindBy(xpath = "//button[contains(text(),'Add Project')]")
	WebElement button_Add_Project;

	@FindBy(xpath = "//div[@class='message']")
	WebElement capture_success_message;

	public void clickOnProjectTagsPlusSymbol() throws InterruptedException {

		Thread.sleep(5000);
		
		icon_AddImport_Project.click();

		Thread.sleep(1000);

		dropdown_Add_Project.click();
	}

	public void enterProjectnameDescriptionAndClickOnRadiobutton(String projectname, String description) throws InterruptedException {

		Thread.sleep(5000);
		
		textbox_ProjectName.sendKeys(projectname);

		textbox_Description.sendKeys(description);

		radiobutton_enableSimpleBranching.click();

		// radiobutton_disableBranching.click();

		button_Add_Project.click();
	}

}
