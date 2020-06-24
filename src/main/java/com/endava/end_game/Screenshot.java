package com.endava.end_game;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Screenshot {
    private static int stepNumber;

    public static void screenshot(WebDriver webDriver, Scenario scenario) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        BufferedImage image = Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE, true).getImage();
        try {
            ImageIO.write(image, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final byte[] screenShot = output.toByteArray();
        scenario.embed(screenShot, "image/png");
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0,0)");
    }
}