package com.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	static {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
			properties = new Properties();
			properties.load(fis);
		}catch (IOException e) {
			throw new RuntimeException("config.properties not found: " + e.getMessage());
		}
	}
	public static String getBrowser() {
		return properties.getProperty("browser");
	}
	public static String getBaseURL() {
		return properties.getProperty("baseURL");
	}
	public static int getImplicitWait() {
		return Integer.parseInt(properties.getProperty("implicitWait"));
	}
	public static int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("explicitWait"));
	}
}
