package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkBase {

	public static WebDriver driver = null;
	public static String path = System.getProperty("user.dir");
	public static Properties property = null;

	public static void getProperty() {
  
		property = new Properties();
		try {
			FileInputStream file = new FileInputStream(path + "/src/main/java/com/qa/confg/UserData.properties");
			property.load(file);
		} catch (Exception e) {
		}
	}

	public static void browserLaunch() {
		getProperty();
//		System.setProperty("webdriver.chrome.driver", path+"/Browsr/chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();\
		driver.get(property.getProperty("url"));
	}

	public static void browserLaunch(String browser) {
		getProperty();

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {  
			WebDriverManager.firefoxdriver().setup();   
			driver = new FirefoxDriver();
		}    

		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
	}
}
