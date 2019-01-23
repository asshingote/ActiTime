package com.ECFW.ActitimeTEST;

import org.testng.annotations.Test;

import com.ECFW.ActiTimeGENERIC.CommonWebDriveractions;
import com.ECFW.ActiTimeGENERIC.ExcelHandle;
import com.ECFW.ActiTimePOM.ActitimeLoginPage;
import com.ECFW.ActiTimePOM.ActiveProjectsPage;
import com.ECFW.ActiTimePOM.BasePage;
import com.ECFW.ActiTimePOM.OpenTaskPage;

public class TestArchiveProject extends BaseTest
{
	@Test
	public void archiveProject()
	{
		logger = extent.createTest("archiveProject");
		ActitimeLoginPage rv=new ActitimeLoginPage(driver);
		String user= ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 0);
		String pass = ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 1);
		rv.setLoginCredentials(user, pass);
		rv.appLogin();
		BasePage base=new BasePage(driver);
		base.setTaskClick();
		OpenTaskPage open=new OpenTaskPage(driver);
		open.selectActiveProjects();
		ActiveProjectsPage active=new ActiveProjectsPage(driver);
		active.selectCustomer(1);
		active.selectShowOption();
		active.selectCustomerProject();
		active.selectArchive();
		CommonWebDriveractions.alertVerification(driver, 10);
		CommonWebDriveractions.alertAccept(driver);
		active.verifyArchiveMsg();
		active.appLogout();
	}
}

