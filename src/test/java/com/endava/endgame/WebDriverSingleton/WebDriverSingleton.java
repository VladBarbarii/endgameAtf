package com.endava.endgame.WebDriverSingleton;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverSingleton {
    private static WebDriverSingleton instance = null;
    private static WebDriver driver;

    private WebDriverSingleton(DriverName driverName) throws IOException {
        InputStream input = new FileInputStream("src/test/resources/application.properties");
        Properties prop = new Properties();
        prop.load(input);
        String driverType = driverName.toString().toLowerCase();
        System.setProperty(prop.getProperty(driverType + "_driver"), prop.getProperty(driverType + "_path"));
        System.out.println(prop.getProperty(driverType + "_driver")+prop.getProperty(driverType + "_path"));
        driver = DriverCreator.getDriver(driverName);
    }

    public static WebDriver getDriver(DriverName driverName) throws IOException {
        if (instance == null) {
            instance = new WebDriverSingleton(driverName);
        }
        return driver;
    }
}
