package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, description = "Valid login with correct credentials")
    public void validLoginTest() {
        loginPage = new LoginPage();
        loginPage.login("john", "demo");

        // Verify URL changed to overview page after login
        Assert.assertTrue(loginPage.isLoginSuccessful(),
            "Login failed — URL did not change to overview!");
        System.out.println("PASS: Valid login successful");
    }

    @Test(priority = 2, description = "Invalid login with wrong password")
    public void invalidLoginTest() {
        loginPage = new LoginPage();
        loginPage.login("john", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
            "Error message not displayed for invalid login!");
        System.out.println("PASS: Invalid login shows error correctly");
    }

    @Test(priority = 3, description = "Login with empty credentials")
    public void emptyCredentialsTest() {
        loginPage = new LoginPage();
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
            "Error message not displayed for empty credentials!");
        System.out.println("PASS: Empty credentials shows error correctly");
    }
}