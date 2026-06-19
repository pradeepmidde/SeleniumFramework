package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.automation.config.ConfigReader;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            // Always add headless flags for CI — check env variable
            String ciEnv = System.getenv("CI");
            String headlessProp = System.getProperty("headless");

            if ("true".equals(headlessProp) || "true".equals(ciEnv)) {
                System.out.println("Running in HEADLESS mode");
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--remote-debugging-port=9222");
            } else {
                System.out.println("Running in NORMAL mode");
                options.addArguments("--start-maximized");
            }

            driver.set(new ChromeDriver(options));

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new org.openqa.selenium.firefox.FirefoxDriver());

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        getDriver().manage().timeouts()
            .implicitlyWait(ConfigReader.getImplicitWait(), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}