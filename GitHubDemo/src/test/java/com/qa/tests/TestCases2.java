package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;

public class TestCases2 extends LoginPage {

	@BeforeMethod
	@Parameters("myBrowser")
	public void launchMethod(String myBrowser) {  
		browserLaunch(myBrowser);
	}

	@Test(dataProvider = "testData")
	public void testCase1(String user, String pass) {  
		userLogin(user, pass);
	}

	@DataProvider(name = "testData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { { "harry@gmail.com", "Harry@1234" }, { "harry@gmail.com", "Harry@1234" } };
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();   
	}

}
