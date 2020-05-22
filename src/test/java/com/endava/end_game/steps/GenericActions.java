package com.endava.end_game.steps;

import com.endava.end_game.web_driver_singleton.WebDriverSingleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class GenericActions {
    private Logger logger = LogManager.getLogger(GenericActions.class);
    private static final long timeout = 20L;

    public static void click(WebElement webElement) {
        waitElement(webElement, WaitCondition.CLICKABLE);
        webElement.click();
    }

    public static void waitElement(WebElement webElement, WaitCondition condition) {
        ExpectedCondition<?> expectedCondition = null;
        switch (condition) {
            case CLICKABLE:
                expectedCondition = ExpectedConditions.elementToBeClickable(webElement);
                break;
            case VISIBILITY:
                expectedCondition = ExpectedConditions.visibilityOf(webElement);
                break;
            case INVISIBILITY:
                expectedCondition = ExpectedConditions.invisibilityOf(webElement);
                break;
        }
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(expectedCondition);
    }

    public static void enterValue(WebElement webElement, String value) {
        waitElement(webElement, WaitCondition.VISIBILITY);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public enum WaitCondition {
        VISIBILITY, INVISIBILITY, CLICKABLE
    }

    public static void getText(WebElement webElement) {
        webElement.getText().trim();
    }

    public static void refreshPage() {
        WebDriver driver = WebDriverSingleton.getDriver();
        driver.navigate().refresh();
    }
}
