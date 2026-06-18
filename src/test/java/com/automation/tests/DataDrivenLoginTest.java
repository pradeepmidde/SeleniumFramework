package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.ExcelUtils;

public class DataDrivenLoginTest extends BaseTest {

    // Path to Excel file
    private String excelPath = System.getProperty("user.dir")
        + "/src/test/resources/LoginData.xlsx";

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        ExcelUtils.loadExcel(excelPath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();

        // rowCount = last row index, row 0 = header so start from 1
        Object[][] data = new Object[rowCount][3];

        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
            data[i - 1][2] = ExcelUtils.getCellData(i, 2); // ExpectedResult
        }

        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "loginData",
          description = "Data driven login test from Excel")
    public void dataDriverLoginTest(String username,
                                    String password,
                                    String expectedResult) {

        System.out.println("Testing → Username: " + username
            + " | Password: " + password
            + " | Expected: " + expectedResult);

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        if (expectedResult.equalsIgnoreCase("pass")) {
            Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Expected PASS but login failed for user: " + username);
            System.out.println("✅ PASS row validated correctly");

        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Expected FAIL but no error shown for user: " + username);
            System.out.println("✅ FAIL row validated correctly");
        }
    }
}