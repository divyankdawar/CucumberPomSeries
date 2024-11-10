package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Blog {
	
	private WebDriver driver;
	
	private By blogButton = By.xpath("//a[contains(text(),'Blog')]");
	private By Marketing = By.xpath("//a[@class='cta-tag t5 fw-700'][normalize-space()='Marketing']");
	private By marketingResult = By.xpath("//h2[contains(text(),'“Marketing”')]");
	
	public Blog(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnBlog() {
		driver.findElement(blogButton).click();
	}
	
	public String getBlogTitle() {
		return driver.getTitle();
	
	}
	
	public void switchWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
	}
	
	public void getMarketing() {
		
		driver.findElement(Marketing).click();
	
		//h2[contains(text(),'“Marketing”')]
	}
	public void marketingResults() {
		driver.findElement(marketingResult).click();
	}
	
	

}
