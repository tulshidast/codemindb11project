package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static String readProperty(String key) {

		File file = new File("src/test/resources/masterData.properties");

		Properties properties = new Properties();

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties.getProperty(key);

	}

	public static void selectValueFromDropdown(WebElement dropdown, String option) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public static ArrayList<String> getAllOptionsFromDropdown(WebElement dropdown) {
		Select select = new Select(dropdown);
		ArrayList<String> options = new ArrayList<String>();
		List<WebElement> elementList = select.getOptions();
		for (WebElement option : elementList) {
			options.add(option.getText());
		}
		return options;
	}

	public static ArrayList<String> readExcelFile(String sheetName) throws InvalidFormatException, IOException {

		ArrayList<String> userData = new ArrayList<String>();

		File file = new File("src/test/resources/userRegistrationData.xlsx");

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);

		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

		int lastRowNumber = xssfSheet.getLastRowNum();

		for (int i = 1; i <= lastRowNumber; i++) {
			XSSFRow xssfRow = xssfSheet.getRow(i);

			int lastCellNum = xssfRow.getLastCellNum();

			for (int j = 0; j < lastCellNum; j++) {
				userData.add(xssfRow.getCell(j).getStringCellValue());
			}
		}
		xssfWorkbook.close();
		return userData;

	}

	public static void takesSnapshot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File f = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,
				new File("src/test/resources/screenshots/" + fileName + System.currentTimeMillis() + ".png"));
	}

	public WebDriver getDriver(WebDriver driver) {

		if (driver != null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}

		return driver;
	}

}
