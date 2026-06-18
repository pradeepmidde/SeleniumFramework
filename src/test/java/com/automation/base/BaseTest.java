package com.automation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.config.ConfigReader;
import com.automation.utils.DriverManager;

public class BaseTest {

	@BeforeMethod
	public void setUp() {
DriverManager.initDriver();
DriverManager.getDriver().get(ConfigReader.getBaseURL());
}
	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
