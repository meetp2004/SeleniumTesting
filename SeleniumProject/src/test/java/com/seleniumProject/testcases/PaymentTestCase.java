package com.seleniumProject.testcases;

import org.testng.annotations.Test;

import com.seleniumProject.pages.BaseTest;
import com.seleniumProject.pages.DashBoardOption;
import com.seleniumProject.pages.DashBoardPage;
import com.seleniumProject.pages.LoginPage;
import com.seleniumProject.pages.PaymentPage;
import com.seleniumProject.utility.ReadExcelFile;

public class PaymentTestCase extends BaseTest{
	
String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
	@Test
	void testcourses()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 1);
		lp.loginToPortal(username, password);
		DashBoardOption dbo = new DashBoardOption(driver);
		DashBoardPage dp = new DashBoardPage(driver);
		
		dp.dashboardclick();
		dbo.offeracad();
		dbo.subscribeClick();
		
		PaymentPage pg= new PaymentPage(driver);
		String crdnum=ReadExcelFile.getCellValue(fileName, "payment", 0, 0);
		String expdate=ReadExcelFile.getCellValue(fileName, "payment", 0, 1);
		String cvcnum=ReadExcelFile.getCellValue(fileName, "payment", 0, 2);
		
		pg.paymentOption(crdnum, expdate, cvcnum);
		
	}

}
