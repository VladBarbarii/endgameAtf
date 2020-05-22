package com.endava.end_game.steps.hooks;

import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterAll;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.url;

public class Hook {

    @Before
    public static void setupWebDriver() {
        getDriver().get(url);
        //getDriver().manage().window().maximize();
    }

 /*   @AfterStep
    public void afterStep(Scenario scenario){
        Screenshot.screenshot(getDriver(),scenario);
    }*/
    @AfterAll
    public static void closeDriver() {
        getDriver().quit();
    }
}
