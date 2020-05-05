package com.endava.endgame.WebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCreator {
    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getIEDriver() {
        return new InternetExplorerDriver();
    }

    public static WebDriver getDriver(DriverName driverName) {
        switch (driverName) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFireFoxDriver();
            case IE:
                return getIEDriver();
            default:
                return null;
        }
    }
}
