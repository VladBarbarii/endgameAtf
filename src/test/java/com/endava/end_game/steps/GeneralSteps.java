package com.endava.end_game.steps;

import com.endava.end_game.AssertThatWrapper;
import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.LoginPage;
import com.endava.end_game.page_objects.SystemAdminHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static com.endava.end_game.AssertThatWrapper.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.endava.end_game.AssertThatWrapper;

import static com.endava.end_game.steps.GenericActions.*;
import static com.endava.end_game.steps.GenericActions.*;
import static org.hamcrest.Matchers.is;

public class GeneralSteps {
    private static final String allowedCharacters = "[^a-zA-Z0-9:]";

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
    }

    //TODO throw custom exception
    @When("User clicks on {string} {string}")
    public void clickOnTheElement(String element, String elementType) {
        String methodName = "get" + element + elementType;
        click(getElementByName(methodName));
    }

    @When("User enters {string} in {string} field")
    public void enterValueInTheField(String value, String field) {
        String methodName = "get" + field;
        enterValue(getElementByName(methodName), value);
    }

    private WebElement getElementByName(String methodName) {
        WebElement webElement = null;
        methodName = methodName.replaceAll(allowedCharacters, "");
        Object pageObj = ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        try {
            Method[] methods = pageObj.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().toLowerCase().equals((methodName).toLowerCase())) {
                    webElement = (WebElement) method.invoke(pageObj);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return webElement;
    }

    @Then("User is on {string} page")
    public void getPageName(String pageName) {
        try {
            pageName = pageName.replaceAll(allowedCharacters, "");
            Class<?> classname = Class.forName("com.endava.end_game.page_objects." + pageName);
            ScenarioContext.getInstance().saveData(ScenarioKeys.PAGE, classname.newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void assertMessage(String methodName, String message) {
        waitElement(getElementByName(methodName));
        AssertThatWrapper.assertThat(getElementByName(methodName).getText(), is(message));
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String message) {
        String methodName = "get" + message + "Message";
        assertMessage(methodName, message);
    }

    @Then("{string} message is displayed under {string} field")
    public void messageIsDisplayedUnderField(String message, String field) {
        String methodName = "get" + message + "MessageUnder" + field;
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
        waitElement(getElementByName(methodName));
        assertThat(getElementByName(methodName).getText(), is(message));
    }
}