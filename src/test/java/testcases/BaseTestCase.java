package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.Utility;

public class BaseTestCase {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(Utility.readProperty("envUrl"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
