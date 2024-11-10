package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/Blog.feature"},
		glue = {"stepdefinitions","AppHooks"},
//		tags = "@ShoppingCartSummaryValidation",
		plugin = {"pretty"})

public class MyTestRunner {
	


}
