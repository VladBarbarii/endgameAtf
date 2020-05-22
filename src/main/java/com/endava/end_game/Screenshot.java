package com.endava.end_game;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

//Utility class for taking screenshots
public class Screenshot {
    private static int stepNumber;

    public static void screenshot(WebDriver webDriver, Scenario scenario) {
        String separator = System.getProperty("file.separator");
        String target = "target" + separator + "screenshots" + separator + scenario.getName();
        Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE).
                withName(scenario.getName() + "_" + scenario.getLine() + "_" + ++stepNumber).
                save(target);

    }

    public static void setStepNumber(int stepNumber) {
        Screenshot.stepNumber = stepNumber;
    }
}