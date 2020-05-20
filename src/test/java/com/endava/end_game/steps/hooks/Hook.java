package com.endava.end_game.steps.hooks;

import com.endava.end_game.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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

    @AfterStep
    public void afterStep(Scenario scenario){
        Screenshot.screenshot(getDriver(),scenario);
    }
    @After
    public static void closeDriver() {
        getDriver().quit();
    }
}
