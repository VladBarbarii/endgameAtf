package com.endava.end_game.steps;

import com.endava.end_game.AssertThatWrapper;
import com.endava.end_game.page_objects.CandidatesPage;
import com.endava.end_game.page_objects.MyTimesheetsPage;
import com.endava.end_game.web_driver_singleton.WebDriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;

import static com.endava.end_game.steps.GenericActions.*;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;
import static org.hamcrest.Matchers.is;


public class TestStepsAndrei {
    private static final Logger logger = LogManager.getLogger(TestStepsAndrei.class);
    private static final String myTimesheetsPage = "https://orangehrm-demo-6x.orangehrmlive.com/client/#/time/timesheets/2170";
    private static final MyTimesheetsPage MY_TIMESHEETS_PAGE = new MyTimesheetsPage();
    private static final CandidatesPage CANDIDATES_PAGE = new CandidatesPage();
    private static final String RESUME_PATH = "C:\\Users\\atrosinenco\\IdeaProjects\\finaltask2020\\src\\test\\resources";
    private static final String CANDIDATE_ROWS = "//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr";


    @Then("New activity has been added")
    public void newActivityHasBeenAdded() {
        AssertThatWrapper.assertThat(MY_TIMESHEETS_PAGE.getProjectLine().isDisplayed(), is(true));
    }


    @And("There is no {string} added")
    public void thereIsNoActivityAdded(String element) {
        getDriver().get(myTimesheetsPage);
        waitElement(MY_TIMESHEETS_PAGE.getAddActivityButton(), WaitCondition.VISIBILITY);
        Assertions.assertThrows(NoSuchElementException.class, () -> MY_TIMESHEETS_PAGE.getProjectLine().click());
        getDriver().get(WebDriverSingleton.url);
    }

    @And("User chooses {string} from computer")
    public void userChoosesResumeFromComputer(String file) {
        CANDIDATES_PAGE.getSelectResume().sendKeys(RESUME_PATH + System.getProperty("file.separator") + file);
    }

    @Given("The resume file has been prepared")
    public void theResumeFileHasBeenPrepared() {
    }

    @And("New candidate has been added")
    public void newCandidateHasBeenAdded() {
        click(CANDIDATES_PAGE.getSearchButton());
        enterValue(CANDIDATES_PAGE.getSearchField(), CANDIDATES_PAGE.getNameValue());
        logger.info("New candidate has been added");
    }
}