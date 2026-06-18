package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.config.ConfigReader;
import com.automation.utils.DriverManager;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
public BasePage() {
this.driver=DriverManager.getDriver();
this.wait= new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
}
protected void clickElement(By locator) {
	wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}
protected void typeText(By locator, String text) {
	WebElement el=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	el.clear();
	el.sendKeys(text);
}
protected String getElementText(By locator) {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
}
protected boolean isElementVisible(By locator) {
	try {
		return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();
	} 
		catch (Exception e) {
            return false;
	}
}
public String getPageTitle() {
	return driver.getTitle();
}
public void navigateTo(String url) {
	driver.get(url);
}
}
