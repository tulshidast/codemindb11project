package testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;
import util.Utility;

public class VerifyCountryDropdown extends BaseTestCase {

	RegistrationPage registrationPage;
	HomePage homePage;

	@Test
	public void verifyCountryDropdown() {
		homePage = new HomePage(driver);
		registrationPage = homePage.navigateToRegisterPage(driver);
		ArrayList<String> dropdownOptions = Utility.getAllOptionsFromDropdown(registrationPage.getCountryDropdown());
		assertEquals(dropdownOptions.size(), 264, "Number of countries are missing");
	}

}
