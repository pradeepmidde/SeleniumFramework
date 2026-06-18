package com.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	
	public static void initDriver() {
		String browser = ConfigReader.getBrowser().toLowerCase();
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
		}
		else if (browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else {
			throw new RuntimeException("browser not supported: "+browser);
		}
		
		getDriver().manage().timeouts()
        .implicitlyWait(ConfigReader.getImplicitWait(), TimeUnit.SECONDS);
		}
	public static WebDriver getDriver() {
        return driver.get();
}
	
	public static void quitDriver() {
		if(driver.get() !=null) {
			driver.get().quit();
			driver.remove();
		}
		
		}
}