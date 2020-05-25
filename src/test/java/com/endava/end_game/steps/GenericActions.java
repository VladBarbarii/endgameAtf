package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.exceptions.MethodNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import static com.endava.end_game.steps.GeneralSteps.PROHIBITED_CHARACTERS;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class GenericActions {
    private static Logger logger = LogManager.getLogger(GenericActions.class);
    private static final long timeout = 20L;

    public static void click(WebElement webElement) {
        waitElement(webElement, WaitCondition.CLICKABLE);
        webElement.click();
    }

    public static void waitElement(WebElement webElement, WaitCondition condition) {
        ExpectedCondition<?> expectedCondition = null;
        switch (condition) {
            case CLICKABLE:
                expectedCondition = ExpectedConditions.and(ExpectedConditions.elementToBeClickable(webElement),
                        ExpectedConditions.visibilityOf(webElement));
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

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static WebElement getElementByName(String methodName) {
        WebElement webElement = null;
        methodName = methodName.replaceAll(PROHIBITED_CHARACTERS, "");
        Object pageObj = ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        try {
            Method[] methods = pageObj.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().toLowerCase().equals((methodName).toLowerCase())) {
                    webElement = (WebElement) method.invoke(pageObj);
                    logger.info("Method: " + method.getName() + " on " + pageObj.getClass() + " invoked");
                }
            }
        } catch (Exception e) {
            try {
                throw new MethodNotFoundException();
            } catch (MethodNotFoundException methodNotFoundException) {
                logger.error("Method not found");
            }
        }
        return webElement;
    }

    public static String isFileDownloaded(String downloadPath, String fileName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                dirContents[i].delete();
                return "File is downloaded";
            }
        }
        return "File is not downloaded";
    }
}
