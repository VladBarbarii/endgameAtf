package com.endava.end_game.web_driver_singleton;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
            driver = DriverFactory.getDriver(driverType);
        } catch (IOException e) {
            logger.error("File Not Found");
        }
    }

    public static WebDriver getDriver(){
        if (instance == null) {
            System.out.println("heloojwoiwho");
            instance = new WebDriverSingleton();
            logger.info("New WebDriver's instance created");
        }
        return driver;
    }
}

