package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the threadlocal driver on the bases of given browser
	 * @param browser
	 * @return this will return tldriver
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);
		
		if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");  
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
     /**
      * The synchronized keyword ensures that only one thread can access and 
      * modify the tlDriver variable at a time, preventing race conditions and data inconsistencies.
      * @return
      */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
