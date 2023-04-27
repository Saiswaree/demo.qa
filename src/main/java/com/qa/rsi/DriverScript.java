package com.qa.rsi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Class: Driverscript
 * This class is responsible for loading the properties file and loading the application
 * Developed by: Sai
 * Date: 4/25/2023
 * Reviewed by: Manager
 */

public class DriverScript {
	public static WebDriver driver;
	Properties prop;

	public DriverScript() {
		try {
			File file = new File("./atConfig/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("Unable to load the properties file, please check " + e.getMessage());
		}
	}

	public void initApplication() throws InterruptedException {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./atBrowser/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./atBrowser/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./atBrowser/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.err.println("The browser parameter is not supported, please check the config file.");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		getURL();
		Thread.sleep(3000);
	}

	public void getURL() {
		String url = prop.getProperty("url");
		driver.get(url);
	}

	public void quitDriver() {
		driver.close();
	}
}
