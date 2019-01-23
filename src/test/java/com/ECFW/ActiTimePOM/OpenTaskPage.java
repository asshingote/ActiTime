package com.ECFW.ActiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenTaskPage extends BasePage
{
	@FindBy(xpath="(//input[@type=\'checkbox\'])[1]")
	private WebElement taskcheckbox;
	@FindBy(xpath="//input[@value=\'Delete Selected Tasks\']")
	private WebElement taskdeletebutton;
	@FindBy(xpath="//input[@class='confirmDialogApplyButton']")
	private WebElement confirmtaskdeletebutton;
	@FindBy(xpath="//span[@class=\'successmsg\']")
	private WebElement taskdeletemsg;
	@FindBy(xpath="//a[text()='Projects & Customers']")
	private WebElement projects;
	
	public OpenTaskPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void selectCheckbox()
	{
		taskcheckbox.click();
	}
	
	public void selectDelete()
	{
		taskdeletebutton.click();
	}
	
	public void selectPopupDelete()
	{
		confirmtaskdeletebutton.click();
	}
	
	public void verifyTaskDelete()
	{
		Assert.assertTrue(taskdeletemsg.isDisplayed());
	}
	
	public void selectActiveProjects()
	{
		projects.click();
	}
}

