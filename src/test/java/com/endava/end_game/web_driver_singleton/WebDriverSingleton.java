package com.endava.end_game.web_driver_singleton;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverSingleton {
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
            System.out.println(prop.getProperty(driverType + "_driver")+prop.getProperty(driverType + "_path"));
            driver = DriverFactory.getDriver(driverType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return driver;
    }
}

