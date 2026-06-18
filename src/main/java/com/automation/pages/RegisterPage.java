package com.automation.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    // Locators
    private By firstNameField   = By.id("customer.firstName");
    private By lastNameField    = By.id("customer.lastName");
    private By addressField     = By.id("customer.address.street");
    private By cityField        = By.id("customer.address.city");
    private By stateField       = By.id("customer.address.state");
    private By zipCodeField     = By.id("customer.address.zipCode");
    private By phoneField       = By.id("customer.phoneNumber");
    private By ssnField         = By.id("customer.ssn");
    private By usernameField    = By.id("customer.username");
    private By passwordField    = By.id("customer.password");
    private By confirmPassField = By.id("repeatedPassword");
    private By registerButton   = By.xpath("//input[@value='Register']");

    // Success — "Your account was created successfully. You are now logged in."
    private By successMessage   = By.xpath("//div[@id='rightPanel']//p | //h1[contains(text(),'Welcome')] | //p[contains(text(),'created')] | //p[contains(text(),'logged')]");

    // Username already taken error
    private By usernameError    = By.id("customer.username.errors");

    // Navigate to register page
    public void goToRegisterPage() {
        clickElement(By.linkText("Register"));
    }

    // Fill form
    public void fillRegistrationForm(String firstName, String lastName,
            String address, String city, String state, String zip,
            String phone, String ssn, String username, String password) {

        typeText(firstNameField,   firstName);
        typeText(lastNameField,    lastName);
        typeText(addressField,     address);
        typeText(cityField,        city);
        typeText(stateField,       state);
        typeText(zipCodeField,     zip);
        typeText(phoneField,       phone);
        typeText(ssnField,         ssn);
        typeText(usernameField,    username);
        typeText(passwordField,    password);
        typeText(confirmPassField, password);
    }

    public void clickRegister() {
        clickElement(registerButton);
    }

    // Check if username error is shown
    public boolean isUsernameAlreadyTaken() {
        return isElementVisible(usernameError);
    }

    // Verify success by checking URL changed
    public boolean isRegistrationSuccessful() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // After successful registration URL contains "register" and page shows welcome
        String url = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();
        return pageSource.contains("created successfully") 
            || pageSource.contains("Welcome") && url.contains("register")
            || pageSource.contains("logged in");
    }
}