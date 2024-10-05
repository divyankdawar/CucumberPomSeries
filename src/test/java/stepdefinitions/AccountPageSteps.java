package stepdefinitions;

import com.qa.factory.DriverFactory;

import org.junit.Assert;
import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
       List<Map<String, String>> credList = credTable.asMaps();
       String userName = credList.get(0).get("username");
       String password = credList.get(0).get("password");
       
       DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
       accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title is: " + title);

	}

//	@When("user gets the title of the page")
//	public void user_gets_the_title_of_the_page() {
//
//	}

//		@Then("page title should be {string}")
//	public void page_title_should_be(String string) {
//
//	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> expAccountsSectionsList = sectionsTable.asList();
		System.out.println("Expected accounts section list: " + expAccountsSectionsList);
		
		List<String> actualAccountsSectionList = accountsPage.getAccountSelectionList();
		System.out.println("Actual accounts section list: " + actualAccountsSectionList);
		
		Assert.assertTrue(expAccountsSectionsList.containsAll(actualAccountsSectionList));
		
	
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
		
	}

}
