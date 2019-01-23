package com.ECFW.ActiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPage 
{
	@FindBy(name="username")
	private WebElement un;
	@FindBy(name="pwd")
	private WebElement pwd;
	@FindBy(id="loginButton")
	private WebElement loginbutton;
	
	public ActitimeLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setLoginCredentials(String user, String pass)
	{
		un.sendKeys(user);
		pwd.sendKeys(pass);
	}
	
	public void appLogin()
	{
		loginbutton.click();
	}
}
