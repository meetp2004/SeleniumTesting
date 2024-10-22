package com.seleniumProject.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.seleniumProject.pages.BaseTest;
import com.seleniumProject.pages.DashBoardPage;
import com.seleniumProject.pages.LoginPage;
import com.seleniumProject.utility.ReadExcelFile;

public class DashBoardTest extends BaseTest {


	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

	@Test
	public void VerifyLogin() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String username= ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 0);
		String password= ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 1);
		System.out.println(username+" "+password);
		lp.loginToPortal(username, password);
		
		if((username.equals("Demo12")) && (password.equals("Test123456$")))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void fetchDashboardText() throws IOException
	{
		DashBoardPage dp=new DashBoardPage(driver);
		String as=ReadExcelFile.getCellValue(fileName, "dash", 0, 0);
		System.out.println("This is excel data "+as);
		dp.dashboardportal(ReadExcelFile.getCellValue(fileName, "dash", 0, 0));
		dp.dashboardclick();

	}
	

}
