package com.endava.end_game.steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.url;

public class Hook {

    @Before
    public static void setupWebDriver() {
        WebDriver singleton = getDriver();
        singleton.get(url);
        singleton.manage().window().maximize();
    }

    @After
    public static void closeDriver() {
        getDriver().quit();
    }
}
