package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCloth {

	private WebDriver driver;
	//1. Locators

	private By womenButton = By.cssSelector("a[title='Women']");
	private By womenBlouse = By.cssSelector("a[class='product-name'][title = 'Blouse']");
	private By whiteDress = By.xpath("//a[@id='color_8'and @title = 'White']");
	private By addToCart = By.xpath("//span[contains(text(),'Add to cart')]");
	private By checkout = By.cssSelector("a[title='Proceed to checkout'] ");
    private By viewcart = By.xpath("//a[@title='View my shopping cart'] /b");
    private By productInfos = By.cssSelector("td.cart_description  small");
    
    
    
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
		driver.findElement(checkout).click();
	}
	public void viewShoppingCart() {
		driver.findElement(viewcart).click();
	}
 
	public List<String> productInfoMethod() {
		List<String> cartSummary = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(productInfos);
		
		for(WebElement e: accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			cartSummary.add(text);
		}
		System.out.println(cartSummary);
		
		return cartSummary;
		
	}
	
	
}
