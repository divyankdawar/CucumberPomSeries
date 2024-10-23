package stepdefinitions;

import java.util.List;
import com.pages.AddCloth;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddClothSteps {
	
	private WebDriver driver;
	private AddCloth clothStep = new AddCloth(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	
	
	@Given("user has logged in to application")
	public void user_has_logged_in_to_application(DataTable credTable) {
	       List<Map<String, String>> credList = credTable.asMaps();
	       String userName = credList.get(0).get("username");
	       String password = credList.get(0).get("password");
	       
	       DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	       accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Account page")
	public void user_is_on_accounts_page() {		
			String title = accountsPage.getAccountsPageTitle();
			System.out.println("Accounts page title is: " + title);

		} 
	

	@When("user clicks the Women Button")
	public void user_clicks_the_women_button() {
		clothStep.clickOnWomen();
	}

	@And("the Women page open")
	public void the_women_page_open() {
		String title = clothStep.getWomenPageTitle();
		System.out.println("Women Page Title is: " + title);
	
	}

	@Then("page title of women Page should be {string}")
	public void page_title_of_women_page_should_be(String title) {
       Assert.assertEquals(title, "Women - My Shop");
	}
	
	@Given("user is on the Women page")
	public void user_is_on_the_women_page() {
		clothStep.clickOnWomen();
	}

	@When("user clicks on blouse")
	public void user_clicks_on_blouse() {
		clothStep.clickOnBlouse();
	}

	@And("change the color to white")
	public void change_the_color_to_white() {
	    clothStep.clickOnWhiteDress();
	}

	@And("Press add to cart button")
	public void press_add_to_cart_button() {
       clothStep.clickOnAddToCart();
	}
	
	@And("the message {string} is displayed")
	public void the_message_is_displayed(String addToCartTitle) throws InterruptedException {
		   Assert.assertEquals(addToCartTitle, "Product successfully added to your shopping cart");
		   
	}
	
	@And("Press Proceed to checkout")
	public void Press_Proceed_to_checkout() {
		clothStep.clickOnProceedToCheckout();
	}
	


	@And("user clicks on the Proceed to checkout button") 
	public void the_following_product_information_should_be_correct() {
		clothStep.ClickOnProceedCheckout();
		
	}
	@Then("The address page with title {string} opens")
	public void user_on_address_page(String actualtitle) throws InterruptedException {
		String expectedtitle = clothStep.getTitleAddress();
		Assert.assertEquals(actualtitle,expectedtitle);
	}
	

	

}
