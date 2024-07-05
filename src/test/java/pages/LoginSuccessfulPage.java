package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSuccessfulPage {

	WebDriver driver;
	WebElement loginSuccessFullMsg;

	public LoginSuccessfulPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginSuccessFullMsg() {
		setLoginSuccessFullMsg();
		return loginSuccessFullMsg;
	}

	private void setLoginSuccessFullMsg() {
		this.loginSuccessFullMsg = driver.findElement(By.xpath("//h3"));
	}

}
