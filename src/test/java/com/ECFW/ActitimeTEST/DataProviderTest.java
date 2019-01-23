package com.ECFW.ActitimeTEST;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ECFW.ActiTimeGENERIC.AutoConstants;
import com.ECFW.ActiTimeGENERIC.CommonWebDriveractions;
import com.ECFW.ActiTimeGENERIC.ExcelUtils;
import com.ECFW.ActiTimePOM.ActitimeLoginPage;
 
public class DataProviderTest extends BaseTest implements AutoConstants
{
	@Test(dataProvider="Authentication")
	public void Registration_data(String sUserName,String sPassword)throws  Exception
	{
		logger = extent.createTest("Registration_data");
		ActitimeLoginPage rv = new ActitimeLoginPage(driver);
		rv.setLoginCredentials(sUserName, sPassword);
		rv.appLogin();
		CommonWebDriveractions.homePageVerify(driver, 10, "Track");
		for (int i = 0; i < 4; i++) 
		{	
			String str= driver.getTitle();
			if(str.contains("Track"))
			{
				ExcelUtils.setExcelData("ACTITIMELOGIN", i, 2, "pass");
			}
			else 
			{	
				ExcelUtils.setExcelData("ACTITIMELOGIN", i, 2, "fail");						
			}
		}
	}
	
	@DataProvider
	public Object[][] Authentication() throws Exception
	{
		Object[][] testObjArray = ExcelUtils.getTableArray(EXCEL_PATH,"ACTITIMELOGIN");
		return testObjArray;
	}
}
