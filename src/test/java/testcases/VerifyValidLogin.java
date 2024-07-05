package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginSuccessfulPage;
import util.Utility;

public class VerifyValidLogin extends BaseTestCase {

	HomePage homePage;
	LoginSuccessfulPage loginSuccessfulPage;

	@Test
	public void verifyValidLogin() throws IOException {

		homePage = new HomePage(driver);
		homePage.getUserNameTextField().sendKeys(Utility.readProperty("userName"));
		homePage.getPasswordTextField().sendKeys(Utility.readProperty("password"));
		homePage.clickSubmitBtn();
		loginSuccessfulPage = new LoginSuccessfulPage(driver);
		Utility.takesSnapshot(driver, "verifyValidLogin");
		assertEquals(loginSuccessfulPage.getLoginSuccessFullMsg().getText(), "Login Successfully");
	}

}
