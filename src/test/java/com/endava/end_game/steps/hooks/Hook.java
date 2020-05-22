package com.endava.end_game.steps.hooks;

import com.endava.end_game.Screenshot;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ConcurrentNavigableMap;

import static com.endava.end_game.steps.GenericActions.click;
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
    public void afterStep(Scenario scenario) {
        Screenshot.screenshot(getDriver(), scenario);
    }

    @AfterAll
    public static void closeDriver() {
        getDriver().quit();
    }
}
