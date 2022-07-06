package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.confg.UtilityPage;

public class CreateAccount extends UtilityPage {

	@FindBy(xpath = "//span[text()='Create an Account']//ancestor::a")
	public WebElement createAccBtn;
	@FindBy(id = "firstname")
	public WebElement firstname;
	@FindBy(id = "lastname")  
	public WebElement lastname;  
	@FindBy(id = "email_address")
	public WebElement email;
	@FindBy(id = "password")
	public WebElement pass;
	@FindBy(id = "confirmation")
	public WebElement confmPass;
	@FindBy(xpath = "//span[text()='Register']//ancestor::button")
	public WebElement submit;

	public void createAccMethod() {
		PageFactory.initElements(driver, this);
		dataFromExcel();

		createAccBtn.click();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

		Assert.assertTrue(isEnable(firstname));
		firstname.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());

		Assert.assertTrue(isEnable(lastname));
		lastname.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());

		Assert.assertTrue(isEnable(email));
		email.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());

		Assert.assertTrue(isEnable(pass));
		pass.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());

		Assert.assertTrue(isEnable(confmPass));
		confmPass.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());

//		Assert.assertTrue(isEnable(submit));
//		submit.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",firstname);
		
		waitForSec(3);
		
		js.executeScript("(window.scrollTo(0,document.body.scrollHeight))");
		
		js.executeScript("history.go(0)");
		
		String title=js.executeScript("return document.title;").toString();
		System.out.println("Title of the page"+title);
		
		js.executeScript("alert('Please Re-Entre the details')");
		
		driver.switchTo().alert().accept();
		waitForSec(2);
		
		js.executeScript("arguments[0].style.border='3px solid red'",firstname);
		js.executeScript("arguments[0].style.border='3px solid green'", lastname);
		js.executeScript("arguments[0].style.border='3px solid blue'", email);
	}
}
