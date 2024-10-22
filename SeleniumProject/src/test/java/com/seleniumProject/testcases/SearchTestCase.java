package com.seleniumProject.testcases;

import org.testng.annotations.Test;

import com.seleniumProject.pages.BaseTest;
import com.seleniumProject.pages.LoginPage;
import com.seleniumProject.pages.SearchPage;
import com.seleniumProject.utility.ReadExcelFile;

public class SearchTestCase extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
	@Test(priority =1)
	void searchCourseTest()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 1);
		lp.loginToPortal(username, password);
		
		SearchPage sp= new SearchPage(driver);
		String searchCourse=ReadExcelFile.getCellValue(fileName, "SearchCourse", 0, 0);
		sp.searchCourse(searchCourse);
	}

}