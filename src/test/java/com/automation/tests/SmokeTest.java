package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utils.DriverManager;

public class SmokeTest extends BaseTest {

	@Test
	public void verifyParabankLoad() {
		String title = DriverManager.getDriver().getTitle();
		System.out.println("page title: " + title);
		Assert.assertTrue(title.contains("ParaBank"), 
	            "Parabank did not load!");
	}
}
