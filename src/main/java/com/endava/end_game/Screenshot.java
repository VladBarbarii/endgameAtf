package com.endava.end_game;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.WebDriver;

//Utility class for taking screenshots
//TestInfo has to be the last arg in list of the arguments of each test
public class Screenshot {
    public static void screenshot(WebDriver webDriver) {
        String separator = System.getProperty("file.separator");
        String target = "target" + separator + "screenshots" + separator;
        Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE).withName("fileName").save(target);
    }
}