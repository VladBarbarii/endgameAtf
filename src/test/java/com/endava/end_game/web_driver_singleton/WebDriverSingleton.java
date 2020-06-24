package com.endava.end_game.web_driver_singleton;

import com.endava.end_game.exceptions.DriverNotRegisteredException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverSingleton {
    private static Logger logger = LogManager.getLogger(WebDriverSingleton.class);
    private static WebDriverSingleton instance = null;
    private static WebDriver driver;
    public static String url;

    private WebDriverSingleton(){
        InputStream input;
        try {
            input = new FileInputStream("src/test/resources/application.properties");
            Properties prop = new Properties();
            prop.load(input);
            String driverType = prop.getProperty("browser");
            url = prop.getProperty("sut_url");
            System.setProperty(prop.getProperty(driverType + "_driver"), prop.getProperty(driverType + "_path"));
            driver = getDriverByName(driverType);
        } catch (IOException e) {
            logger.error("File Not Found");
        }
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getIEDriver() {
        return new InternetExplorerDriver();
    }

    private static WebDriver getDriverByName(String driverName) {
        logger.info("Driver name:" + driverName);
        switch (driverName) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFireFoxDriver();
            case "ie":
                return getIEDriver();
            default:
                try {
                    throw new DriverNotRegisteredException();
                } catch (DriverNotRegisteredException e) {
                    logger.error("Wrong Driver Name");
                    logger.error("Chrome Driver returned instead");
                }
        }
        return getChromeDriver();
    }

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new WebDriverSingleton();
            logger.info("New WebDriver's instance created");
        }
        return driver;
    }

    public static void nullDriver() {
        driver = null;
        instance = null;
    }
}