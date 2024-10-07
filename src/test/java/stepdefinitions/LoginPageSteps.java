package stepdefinitions;

import com.qa.factory.DriverFactory;

import org.junit.Assert;

import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {

	// Then we always write the assertion
	// Given is Kind of Pre Condition
	// When is kind of Action 
	private static String title; 
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitlename) {

		Assert.assertTrue(title.contains(expectedtitlename));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("use enters username {string}")
	public void use_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);

	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
         loginPage.clickOnLogin();
	}

/**
 * Benefits of Separation:

Separation of Concerns: Having separate classes promotes the Single Responsibility Principle (SRP). The AccountPageSteps class focuses on interacting with the page elements through the AccountsPage object, while AccountsPage deals with locating and interacting with elements on the actual page.
Maintainability: As your test suite grows, separate classes make it easier to maintain and update concerns individually. Changes to how you interact with the page (steps) won't affect the actual page object implementation, and vice versa.
Reusability: The AccountsPage class can potentially be reused across different feature files or even other test suites that interact with the same page.
 */




}
