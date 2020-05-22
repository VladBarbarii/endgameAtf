package com.endava.end_game.steps;

import com.endava.end_game.AssertThatWrapper;
import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.exceptions.MethodNotFoundException;
import com.endava.end_game.page_objects.LoginPage;
import com.endava.end_game.page_objects.SystemAdminHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.lang.reflect.Method;

import static com.endava.end_game.AssertThatWrapper.assertThat;
import static com.endava.end_game.steps.GenericActions.*;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;
import static org.hamcrest.Matchers.is;

public class GeneralSteps {
    private Logger logger = LogManager.getLogger(GeneralSteps.class);
    private static final String PROHIBITED_CHARACTERS = "[^a-zA-Z0-9:]";
    private static final String PAGE_OBJECTS_PACKAGE_NAME = "com.endava.end_game.page_objects.";

    @Given("User is logged in as {string}")
    public void userIsLoggedOnAsAnAdmin(String role) {
        LoginPage loginPage = new LoginPage();
        switch (role) {
            case "Admin":
                click(loginPage.getLoginButton());
                break;
            case "System Admin":
                click(loginPage.getLoginRoleButton());
                click(loginPage.getSystemAdminTab());
                break;
        }
        logger.info("User logged as " + role);
    }

    @When("User clicks on {string} {string}")
    public void clickOnTheElement(String element, String elementType) {
        try {
            getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
        } catch (NoSuchElementException e) {
            logger.info("There is no iframe on this page");
        } finally {
            String methodName = "get" + element + elementType;
            click(getElementByName(methodName));
        }
        logger.info("User clicked " + element + " " + elementType);
    }

    @When("User enters {string} in {string} field")
    public void enterValueInTheField(String value, String field) {
        String methodName = "get" + field;
        enterValue(getElementByName(methodName), value);
        logger.info("User entered " + value + " in " + field);
    }

    private WebElement getElementByName(String methodName) {
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

    @Then("User is on {string} page")
    public void getPageName(String pageName) {
        try {
            pageName = pageName.replaceAll(PROHIBITED_CHARACTERS, "");
            Class<?> classname = Class.forName(PAGE_OBJECTS_PACKAGE_NAME + pageName);
            ScenarioContext.getInstance().saveData(ScenarioKeys.PAGE, classname.newInstance());
        } catch (ClassNotFoundException e) {
            logger.error("Class no found");
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessExcpetion");
        } catch (InstantiationException e) {
            logger.error("InstantiationError");
        }
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String message) {
        String methodName = "get" + message + "Message";
        assertMessage(methodName, message);
    }


    @Then("{string} file is downloaded")
    public void fileIsDownloaded(String fileName) {
        String expectedMessage = "File is downloaded";
        String home = System.getProperty("user.home");
        String path = home + "/Downloads";
        AssertThatWrapper.assertThat(isFileDownloaded(path, fileName), is(expectedMessage));
    }

    public String isFileDownloaded(String downloadPath, String fileName) {
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

    @Then("User logout")
    public void user_logout() {
        SystemAdminHomePage systemAdminHomePage = new SystemAdminHomePage();
        click(systemAdminHomePage.getSystemAdminTab());
        click(systemAdminHomePage.getLogOutButton());
    }

    @Then("{string} message is displayed on page")
    public void messageIsDisplayedOnPage(String message) {
        String methodName = "get" + message + "Message";
        waitElement(getElementByName(methodName), WaitCondition.VISIBILITY);
        assertThat(getElementByName(methodName).getText(), is(message));
    }

    public void assertMessage(String methodName, String message) {
        waitElement(getElementByName(methodName), WaitCondition.VISIBILITY);
        AssertThatWrapper.assertThat(getElementByName(methodName).getText(), is(message));
        logger.info(message + " message is displayed");
    }

    @Then("{string} message is displayed under {string} field")
    public void messageIsDisplayedUnderField(String message, String field) {
        String methodName = "get" + message + "MessageUnder" + field;
        assertMessage(methodName, message);
        logger.info(message + " message is displayed under " + field);
    }
}