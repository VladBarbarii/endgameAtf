package com.endava.end_game;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

//Utility class for taking screenshots
//TestInfo has to be the last arg in list of the arguments of each test
public class Screenshot {
    private static int stepNumber = 0;
    private static String currentScenario;

    //TODO stepNumber must be equal with number of scenario in run window
    public static void screenshot(WebDriver webDriver, Scenario scenario) {
        String separator = System.getProperty("file.separator");
        String target = "target" + separator + "screenshots" + separator;
        Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE).withName(scenario.getName() + "_" + scenario.getLine() + "_" + stepNumber++).save(target);
    }
}