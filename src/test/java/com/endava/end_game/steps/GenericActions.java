package com.endava.end_game.steps;

import com.endava.end_game.web_driver_singleton.WebDriverSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class GenericActions {
    private static final long timeout = 20L;

    public static void click(WebElement webElement) {
        waitElement(webElement);
        webElement.click();
    }
    public static void waitElement(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(WebDriverSingleton.getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
