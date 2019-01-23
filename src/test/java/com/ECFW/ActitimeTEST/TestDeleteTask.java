package com.ECFW.ActitimeTEST;

import org.testng.annotations.Test;

import com.ECFW.ActiTimeGENERIC.ExcelHandle;
import com.ECFW.ActiTimePOM.ActitimeLoginPage;
import com.ECFW.ActiTimePOM.BasePage;
import com.ECFW.ActiTimePOM.OpenTaskPage;

public class TestDeleteTask extends BaseTest
	{
		@Test
		public void deleteTask()
		{
			logger = extent.createTest("deleteTask");
			ActitimeLoginPage rv=new ActitimeLoginPage(driver);
			String user= ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 0);
			String pass = ExcelHandle.getExcelData("ACTITIMELOGIN", 0, 1);
			rv.setLoginCredentials(user, pass);
			rv.appLogin();
			BasePage base=new BasePage(driver);
			base.setTaskClick();
			OpenTaskPage open=new OpenTaskPage(driver);
			open.selectCheckbox();
			open.selectDelete();
			open.selectPopupDelete();
			open.verifyTaskDelete();
			open.appLogout();
		}
	}


