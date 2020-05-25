package com.endava.end_game.steps.hooks;

import com.endava.end_game.Screenshot;
import com.endava.end_game.web_driver_singleton.SetProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.*;

public class Hook {
    @Before
    public void setupWebDriver() {
        SetProperties.setProperties();
        WebDriver driver = getDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        Screenshot.screenshot(getDriver(), scenario);
    }
    @After
    public  void closeDriver() {
        getDriver().quit();
        nullDriver();
    }
}
