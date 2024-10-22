package com.seleniumProject.testcases;



import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumProject.pages.BaseTest;
import com.seleniumProject.pages.LoginPage;
import com.seleniumProject.utility.ReadExcelFile;


public class LoginTestDataDrivenTesting extends BaseTest {
	
//	 System.out.println(System.getProperty("user.dir"));
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

	@Test(dataProvider="LoginDataProvider")
	public void VerifyLogin(String userEmail,String userPwd) throws IOException
	{
		LoginPage lp=new LoginPage(driver);

		lp.loginToPortal(userEmail, userPwd);
		
		if(userEmail.equals(userEmail) && userPwd.equals(userPwd))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	

	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "Sheet1");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "Sheet1");
		
		
	    String data[][] = new String[ttlRows - 1][ttlColumns];

	    for (int i = 1; i < ttlRows; i++) {
	        for (int j = 0; j < ttlColumns; j++) {
	            data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "Sheet1", i, j);
	        }
	    }
	    return data;
	}

	
	
	
	
}