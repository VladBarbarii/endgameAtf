package com.endava.endgame;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

//Utility class for taking screenshots
public class Screenshot {
    public static void screenshot(WebDriver webDriver, TestInfo name) {
        String separator = System.getProperty("file.separator");
        String target = "target" + separator + "screenshots" + separator;
        String fileName = name.getDisplayName();
        Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE).withName(fileName).save(target);
    }
}