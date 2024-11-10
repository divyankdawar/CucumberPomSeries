package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.pages.Blog;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import junit.framework.Assert;

public class BlogSteps {

	private WebDriver driver;

	private Blog b = new Blog(DriverFactory.getDriver());

	@And("user clicks on the Blog Section")
	public void user_clicks_on_the_blog_section() {
		b.clickOnBlog();
		b.switchWindow();
		try {
			Thread.sleep(10000); // Keeps the browser open for 10 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//		b.switchWindow();

	}


	@SuppressWarnings("deprecation")
	@Given("page with title {string} opens")
	public void page_with_title_opens(String eCommerceTitle) {
		Assert.assertEquals(eCommerceTitle, "Ecommerce advice and success stories – Blog | PrestaShop");
	}

	@When("user clicks on the Marketing button")
	public void marketing_page() throws InterruptedException
	{
		b.getMarketing();
		Thread.sleep(5000);

	}

	@Then("the marketing results show")
	public void marketing_results() {
		b.marketingResults();
	}

}
