package com.qa.confg;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.qa.base.FrameworkBase;

public class UtilityPage extends FrameworkBase {

	public static FileInputStream file = null;   
	public static Workbook wb = null;
	public static Sheet sheet = null;  

	public static void waitForSec(int i) {   
		try {
			Thread.sleep(1000 * i);
		} catch (Exception e) {
		}
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static boolean isEnable(WebElement str) {
		boolean b = str.isEnabled();
		return b;
	}

	public static boolean isDisplayed(WebElement str) {
		boolean b = str.isDisplayed();
		return b;
	}

	public static boolean isSelected(WebElement str) {
		boolean b = str.isSelected();
		return b;
	}

	public static void dataFromExcel() {

		try {
			file = new FileInputStream(path + "/src/main/java/com/qa/confg/Book1.xlsx");
			wb = new XSSFWorkbook(file);
		} catch (Exception e) {
		}
		sheet = wb.getSheet("Sheet1");
	}
}
