package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;

public class TestCases extends LoginPage {

	@BeforeClass
	@Parameters("myBrowser")
	public void launchMethod(String myBrowser) {
		browserLaunch(myBrowser);
	}

	@Test()
	@Parameters({"username","password"})
	public void testCase1(String username, String password) {
//		createAccMethod();
		userLogin(username,password);
	}
	
	@Test()
	public void testCase6() {
		logoutMethod();
	}
	
//	@Test(groups="Sanity")
//	public void testCase3() {
//		System.out.println("this is sanity test case");
//	}
//	
//	@Test(groups="Smoke")
//	public void testCase4() {
//		System.out.println("this is smoke test case");
//	}
//	
//	@Test(groups= {"Sanity","Regession"})
//	public void testCase5() {
//		System.out.println("this is sanity and regression test case");
//	}
	
	@AfterClass
	public void tesrDown() {
		
		driver.quit();
	}
	
}
