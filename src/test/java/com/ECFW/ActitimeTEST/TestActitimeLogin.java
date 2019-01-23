package com.ECFW.ActitimeTEST;

import org.testng.annotations.Test;

import com.ECFW.ActiTimeGENERIC.ExcelHandle;
import com.ECFW.ActiTimePOM.ActitimeLoginPage;
import com.ECFW.ActiTimePOM.BasePage;

public class TestActitimeLogin extends BaseTest
{
	@Test
	public void actitimeLogin()
	{
		logger = extent.createTest("actitimeLogin");
		ActitimeLoginPage rv=new ActitimeLoginPage(driver);
		String user = ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 0);
		String pass = ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 1);
		rv.setLoginCredentials(user, pass);
		rv.appLogin();
		BasePage base=new BasePage(driver);
		base.appLogout();
	}
}
