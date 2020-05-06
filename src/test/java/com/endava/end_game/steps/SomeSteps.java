package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class SomeSteps {

    @And("User chooses {string} option")
    public void userChoosesTerminateOption(String optionName) {
    }

    @And("User enters {string} in {string} field")
    public void userIntroducesACMELtdSalesInProjectField(String value, String field) {
    }


    @Then("User is on {string} page")
    public void getPageName(String pageName) {
        try {
            pageName = pageName.replaceAll("[^a-zA-Z]","");
            Class<?> classname = Class.forName("com.endava.endgame.page_objects." + pageName);
            ScenarioContext.getInstance().saveData(ScenarioKeys.PAGE, classname.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Then("New {string} has been added")
    public void newActivityHasBeenAdded(String newObjectsName) {

    }
}