package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	WebElement userNameTextField;
	WebElement passwordTextField;
	WebElement submitBtn;
	WebElement registerLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserNameTextField() {
		setUserNameTextField();
		return userNameTextField;
	}

	private void setUserNameTextField() {
		userNameTextField = driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPasswordTextField() {
		setPasswordTextField();
		return passwordTextField;
	}

	private void setPasswordTextField() {
		this.passwordTextField = driver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement getSubmitBtn() {
		setSubmitBtn();
		return submitBtn;
	}

	private void setSubmitBtn() {
		this.submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public void clickSubmitBtn() {
		getSubmitBtn().click();
	}

	public WebElement getRegisterLink() {
		setRegisterLink();
		return registerLink;
	}

	private void setRegisterLink() {
		this.registerLink = driver.findElement(By.xpath("//a[@href='register.php' and text()='REGISTER']"));
	}

	public RegistrationPage navigateToRegisterPage(WebDriver driver) {
		getRegisterLink().click();
		return new RegistrationPage(driver);
	}

}
