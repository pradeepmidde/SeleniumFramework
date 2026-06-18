package com.automation.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.xpath("//input[@value='Log In']");
    private By errorMessage  = By.xpath("//p[@class='error']");
    private By accountHeader = By.xpath("//div[@id='accountTable'] | //h1[contains(text(),'Accounts')] | //div[@class='title']");

    // Actions
    public void enterUsername(String username) {
        typeText(usernameField, username);
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Verifications
    public boolean isLoginSuccessful() {
        // Check URL changed away from login page
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("overview") || currentUrl.contains("account");
    }

    public boolean isErrorMessageDisplayed() {
        return isElementVisible(errorMessage);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }
}