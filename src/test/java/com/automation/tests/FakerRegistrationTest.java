package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.RegisterPage;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.FakerUtils;

public class FakerRegistrationTest extends BaseTest {

    @Test(description = "Register unique user using Faker data")
    public void registerWithFakerDataTest() {

        RegisterPage registerPage = new RegisterPage();
        registerPage.goToRegisterPage();

        String firstName = FakerUtils.getFirstName();
        String lastName  = FakerUtils.getLastName();
        String address   = FakerUtils.getAddress();
        String city      = FakerUtils.getCity();
        String state     = FakerUtils.getState();
        String zip       = FakerUtils.getZipCode();
        String phone     = FakerUtils.getPhoneNumber();
        String ssn       = FakerUtils.getSSN();
        String username  = FakerUtils.getUsername();
        String password  = FakerUtils.getPassword();

        // Log to ExtentReport
        ExtentReportManager.getTest().info("Name     : " + firstName + " " + lastName);
        ExtentReportManager.getTest().info("Address  : " + address + ", " + city + ", " + state);
        ExtentReportManager.getTest().info("Username : " + username);
        ExtentReportManager.getTest().info("Password : " + password);

        // Print to console
        System.out.println("========== FAKER DATA ==========");
        System.out.println("Name    : " + firstName + " " + lastName);
        System.out.println("Address : " + address + ", " + city + ", " + state);
        System.out.println("Zip     : " + zip);
        System.out.println("Phone   : " + phone);
        System.out.println("SSN     : " + ssn);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("================================");

        registerPage.fillRegistrationForm(
            firstName, lastName,
            address, city, state,
            zip, phone, ssn,
            username, password
        );

        registerPage.clickRegister();

        Assert.assertFalse(registerPage.isUsernameAlreadyTaken(),
            "Username already taken: " + username);

        Assert.assertTrue(registerPage.isRegistrationSuccessful(),
            "Registration failed for: " + username);

        System.out.println("PASS: Faker user registered: " + username);
    }
}