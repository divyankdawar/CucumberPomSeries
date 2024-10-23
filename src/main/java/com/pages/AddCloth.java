package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCloth {

	private WebDriver driver;
	//1. Locators

	private By womenButton = By.cssSelector("a[title='Women']");
	private By womenBlouse = By.cssSelector("a[class='product-name'][title = 'Blouse']");
	private By whiteDress = By.xpath("//a[@id='color_8'and @title = 'White']");
	private By addToCart = By.xpath("//span[contains(text(),'Add to cart')]");
	private By checkout = By.cssSelector("a[title='Proceed to checkout'] ");
	private By viewcart = By.xpath("//a[@title='View my shopping cart'] /b");
	private By Checkout = By.cssSelector(".cart_navigation .button.standard-checkout > span");
	//    private By productInfos = By.cssSelector("td.cart_description  small");
	//    private By descriptionBlouse = By.xpath("//td[@class = 'cart_description'] //p");


	public void setUp() {
		// Set the global implicit wait old way ( new way is 
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));)
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Other setup code...
	}
	public void clickOnWomen() {

		driver.findElement(womenButton).click();
	}

	//2. Constructor of the page class:

	public AddCloth(WebDriver driver) {
		this.driver = driver;
	}


	public String getWomenPageTitle() {

		return driver.getTitle();
	}
	public void clickOnBlouse() {
		driver.findElement(womenBlouse).click();
	}

	public void clickOnWhiteDress() {
		driver.findElement(whiteDress).click();
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCart).click();
	}

	public void clickOnProceedToCheckout() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
		//	driver.findElement(checkout).click();
	}
	public void viewShoppingCart() {
		driver.findElement(viewcart).click();
	}
	
	public void ClickOnProceedCheckout() {
		
		//Added Explicit Wait Here
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();
	}
	public String getTitleAddress() throws InterruptedException {
		
		
		return driver.getTitle();

	}





}
