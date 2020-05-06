package com.endava.end_game.web_driver_singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getIEDriver() {
        return new InternetExplorerDriver();
    }

    public static WebDriver getDriver(String driverName) {
        switch (driverName) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFireFoxDriver();
            case "ie":
                return getIEDriver();
            default:
                return null;
        }
    }
}
