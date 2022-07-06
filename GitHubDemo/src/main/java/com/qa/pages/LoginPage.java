package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends CreateAccount {

	@FindBy(xpath = "//input[@id='email']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='pass']")
	public WebElement password;   
 
	@FindBy(xpath = "//span[text()='Login']//ancestor::button")
	public WebElement loginBtn;

	@FindBy(xpath = "//span[text()='Account']//parent::a")
	public WebElement myAccBtn;

	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement logoutBtn;

	public void userLogin() {
		PageFactory.initElements(driver, this);
//		dataFromExcel();

		Assert.assertEquals(getTitle(), "Customer Login");
		Assert.assertTrue(isEnable(username));
		username.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());

		Assert.assertTrue(isEnable(password));
		password.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());

		Assert.assertTrue(isEnable(loginBtn));
		waitForSec(3);
		loginBtn.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", loginBtn);

		Assert.assertEquals(getTitle(), "My Account");
	}

	public void userLogin(String user, String pass) {
		PageFactory.initElements(driver, this);
//		dataFromExcel();   

		Assert.assertEquals(getTitle(), "Customer Login");
		Assert.assertTrue(isEnable(username));
//		username.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		username.sendKeys(user);

		Assert.assertTrue(isEnable(password));
//		password.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		password.sendKeys(pass);

		Assert.assertTrue(isEnable(loginBtn));
		waitForSec(3);
		loginBtn.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", loginBtn);

		Assert.assertEquals(getTitle(), "My Account");
	}

	public void logoutMethod() {
		PageFactory.initElements(driver, this);
		myAccBtn.click();
		logoutBtn.click();

	}

}
