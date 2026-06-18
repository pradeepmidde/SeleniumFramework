package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentReportManager.createTest(testName, description);
        ExtentReportManager.getTest()
            .info("Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest()
            .pass("✅ Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure reason
        ExtentReportManager.getTest()
            .fail("❌ Test FAILED: " + result.getThrowable().getMessage());

        // Take screenshot and attach
        try {
            String base64Screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BASE64);

            ExtentReportManager.getTest().fail("Screenshot on failure:",
                MediaEntityBuilder
                    .createScreenCaptureFromBase64String(base64Screenshot)
                    .build());

        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest()
            .skip("⚠️ Test SKIPPED: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReports();
        System.out.println("✅ Report generated at: /reports/ExtentReport.html");
    }
}