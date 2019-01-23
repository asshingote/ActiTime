package com.ECFW.ActiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	@FindBy(xpath="//a[@class=\'logout\']")
	private WebElement logoutbutton;
	@FindBy(xpath="//a[@class=\'content tasks\']")
	private WebElement task;
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void appLogout()
	{
		logoutbutton.click();
	}
	
	public void setTaskClick()
	{
		 task.click();
	}
}
