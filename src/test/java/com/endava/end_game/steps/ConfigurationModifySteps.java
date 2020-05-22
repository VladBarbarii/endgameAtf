package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.EmailSettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.endava.end_game.steps.GenericActions.click;
import static com.endava.end_game.steps.GenericActions.refreshPage;

public class ConfigurationModifySteps {
        @When("Choose No option for Use Secure Connection")
        public void chooseNoOptionForUseSecureConnection() {
            EmailSettingsPage emailSettingsPage = (EmailSettingsPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
            emailSettingsPage.getNoSecureConnection().click();
        }

        @Given("Sending method is SendingMail")
        public void sendingMethodIsSendingMail() {
            EmailSettingsPage emailSettingsPage = (EmailSettingsPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
            click(emailSettingsPage.getSendingMethodDropdown());
            click(emailSettingsPage.getSendingMethod());
            click(emailSettingsPage.getSaveButton());
            refreshPage();
            click(emailSettingsPage.getSendingMethodDropdown());
            click(emailSettingsPage.getSmtpMethod());
            click(emailSettingsPage.getResetButton());
        }

        @When("User refresh page")
        public void userRefreshPage() {
            refreshPage();
        }
}
