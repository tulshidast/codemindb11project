package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	WebDriver driver;
	WebElement firstNameTextField;
	WebElement lastNameTextField;
	WebElement cityTextField;
	WebElement countryDropdown;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameTextField() {
		setFirstNameTextField();
		return firstNameTextField;
	}

	private void setFirstNameTextField() {
		this.firstNameTextField = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastNameTextField() {
		setLastNameTextField();
		return lastNameTextField;
	}

	private void setLastNameTextField() {
		this.lastNameTextField = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getCityTextField() {
		setCityTextField();
		return cityTextField;
	}

	private void setCityTextField() {
		this.cityTextField = driver.findElement(By.xpath("//input[@name='city']"));
	}

	public WebElement getCountryDropdown() {
		setCountryDropdown();
		return countryDropdown;
	}

	private void setCountryDropdown() {
		this.countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));
	}

}
