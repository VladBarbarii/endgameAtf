package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.endava.end_game.steps.GenericActions.click;
import static com.endava.end_game.steps.GenericActions.waitElement;

public class GeneralSteps {

    @Given("User is logged in as {string}")
    public void userIsLoggedOnAsAnAdmin(final String role) {
        LoginPage loginPage = new LoginPage();
        switch (role) {
            case "Admin":
                GenericActions.click(loginPage.getLoginButton());
                break;
            case "System Admin":
                GenericActions.click(loginPage.getLoginRoleButton());
                GenericActions.click(loginPage.getSystemAdminTab());
                break;
        }
    }

    //TODO throw custom exception
    @When("User clicks on {string} {string}")
    public void clickOnSomething(String value, String elementType) {
        value = value.replaceAll("[^a-zA-Z0-9:]", "");
        Object pageObj = ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        try {
            Method[] methods = pageObj.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().toLowerCase().equals(("get" + value + elementType).toLowerCase())) {
                    WebElement element = (WebElement) method.invoke(pageObj);
                    waitElement(element);
                    click(element);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Then("User is on {string} page")
    public void getPageName(String pageName) {
        try {
            pageName = pageName.replaceAll("[^a-zA-Z]", "");
            Class<?> classname = Class.forName("com.endava.endgame.page_objects." + pageName);
            ScenarioContext.getInstance().saveData(ScenarioKeys.PAGE, classname.newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}