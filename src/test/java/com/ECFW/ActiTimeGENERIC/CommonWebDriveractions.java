package com.ECFW.ActiTimeGENERIC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWebDriveractions 
{
	public static void selectListboxOption(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public static void mouseAction(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public static void alertVerification(WebDriver driver, long time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void alertCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void frameHandle(WebDriver driver, String value)
	{
		driver.switchTo().frame(value);
	}
	public static void homePageVerify(WebDriver driver, long time, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
	}
}

