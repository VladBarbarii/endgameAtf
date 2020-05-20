package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.endava.end_game.steps.GenericActions.click;
import static com.endava.end_game.steps.GenericActions.enterValue;

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

    @And("User enters {string} in {string} field")
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
}