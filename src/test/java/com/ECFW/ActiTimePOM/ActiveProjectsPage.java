package com.ECFW.ActiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ECFW.ActiTimeGENERIC.CommonWebDriveractions;

public class ActiveProjectsPage extends BasePage
{
	@FindBy(name="selectedCustomer")
	private WebElement customerlistbox;
	@FindBy(xpath="//input[contains(@value,\'Show\')]")
	private WebElement showbutton;
	@FindBy(xpath="(//input[@type=\'checkbox\'])[2]")
	private WebElement projectcheckbox;
	@FindBy(xpath="//input[@value=\'Archive Selected\']")
	private WebElement archivebutton;
	@FindBy(xpath="//span[@class=\'successmsg\']")
	private WebElement archiveprojectmsg;
	
	public ActiveProjectsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void selectCustomer(int index)
	{
		CommonWebDriveractions.selectListboxOption(customerlistbox, index);
	}
	
	public void selectShowOption()
	{
		showbutton.click();
	}
	
	public void selectCustomerProject()
	{
		projectcheckbox.click();
	}
	
	public void selectArchive()
	{
		archivebutton.click();
	}
	
	public void verifyArchiveMsg()
	{
		Assert.assertTrue(archiveprojectmsg.isDisplayed());
	}
}

