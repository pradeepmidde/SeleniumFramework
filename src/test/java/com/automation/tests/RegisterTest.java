package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test(description = "Register a new user successfully")
    public void registerNewUserTest() {

        RegisterPage registerPage = new RegisterPage();
        registerPage.goToRegisterPage();

        // Timestamp makes username unique on every single run
        String uniqueUsername = "user" + System.currentTimeMillis();
        String password = "Test@1234";

        System.out.println("Registering with username: " + uniqueUsername);

        registerPage.fillRegistrationForm(
            "John",
            "Doe",
            "123 Main Street",
            "New York",
            "NY",
            "10001",
            "9876543210",
            "123-45-6789",
            uniqueUsername,
            password
        );

        registerPage.clickRegister();

        // Verify not username taken error
        Assert.assertFalse(registerPage.isUsernameAlreadyTaken(),
            "Username already taken — but we used timestamp so this should not happen!");

        // Verify registration success
        Assert.assertTrue(registerPage.isRegistrationSuccessful(),
            "Registration success message not displayed!");

        System.out.println("PASS: New user registered: " + uniqueUsername);
    }
}