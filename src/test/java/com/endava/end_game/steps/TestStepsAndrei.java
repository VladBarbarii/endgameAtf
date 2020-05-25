package com.endava.end_game.steps;

import com.endava.end_game.AssertThatWrapper;
import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.CandidatesPage;
import com.endava.end_game.page_objects.MyTimesheetsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.endava.end_game.steps.GenericActions.*;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.url;
import static org.hamcrest.Matchers.is;


public class TestStepsAndrei {
    private static final Logger logger = LogManager.getLogger(TestStepsAndrei.class);
    private static final MyTimesheetsPage MY_TIMESHEETS_PAGE = new MyTimesheetsPage();
    private static final CandidatesPage CANDIDATES_PAGE = new CandidatesPage();
    private static final String RESUME_PATH = "C:\\Users\\atrosinenco\\IdeaProjects\\finaltask2020\\src\\test\\resources";
    final String firstCandidateRow = "//div[@id='content']/div[8]/div/div[2]/table/tbody/tr";
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static String firstCandidateInfo;


    @Then("New activity has been added")
    public void newActivityHasBeenAdded() {
        AssertThatWrapper.assertThat(MY_TIMESHEETS_PAGE.getProjectLine().isDisplayed(), is(true));
    }


    @And("There is no {string} added")
    public void thereIsNoActivityAdded(String element) {
        final String myTimesheetsPage = "https://orangehrm-demo-6x.orangehrmlive.com/client/#/time/timesheets/2170";
        try {
            getDriver().get(myTimesheetsPage);
            waitElement(MY_TIMESHEETS_PAGE.getAddActivityButton(), WaitCondition.VISIBILITY);
            Assertions.assertThrows(NoSuchElementException.class, () -> MY_TIMESHEETS_PAGE.getProjectLine().click());
        }catch (NoSuchSessionException e) {
            getDriver().get(url);
        }
    }

    @And("User chooses {string} from computer")
    public void userChoosesResumeFromComputer(String file) {
        CANDIDATES_PAGE.getSelectResume().sendKeys(RESUME_PATH + FILE_SEPARATOR + file);
    }

    @Given("The resume file has been prepared")
    public void theResumeFileHasBeenPrepared() {
        String resume = RESUME_PATH + FILE_SEPARATOR + "resume.txt";
        Path resumePath = Paths.get(resume);
        FileWriter fileWriter = null;
        try {
            if (!Files.exists(resumePath)) {
                Files.createFile(resumePath);
            }
            fileWriter = new FileWriter(resume);
            fileWriter.write("Please approve my candidature, I'm fine");
        } catch (IOException e) {
            logger.error("File Not Found");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                logger.error("File closing issue");
            }
        }
    }

    @And("New candidate has been added")
    public void newCandidateHasBeenAdded() {
        click(CANDIDATES_PAGE.getSearchMenu());
        enterValue(CANDIDATES_PAGE.getSearchField(), CANDIDATES_PAGE.getNameValue());
        click(CANDIDATES_PAGE.getSearchButton());
        waitElement(CANDIDATES_PAGE.getPreloader(), WaitCondition.INVISIBILITY);
        Assertions.assertTrue(getDriver().findElements(By.xpath(firstCandidateRow)).size() > 0);
        logger.info("New candidate has been added");
    }

    @And("Sort table by {string} in {string} order")
    public void searchTest(final String tableName, final String order) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
        final String methodName = "get" + "sortby" + tableName;
        logger.info("Sort table by " + tableName + " in " + order + " order");
        CandidatesPage candidatesPage = (CandidatesPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        GeneralSteps generalSteps = new GeneralSteps();
        List<WebElement> actualOrder = null;
        List<String> expectedOrder = null;
        if ("ascending".equals(order)) {
            if (tableName.equals("Date Applied")) {
                click(getElementByName(methodName));
                waitElement(candidatesPage.getPreloader(), WaitCondition.INVISIBILITY);
                click(getElementByName(methodName));
                waitElement(candidatesPage.getPreloader(), WaitCondition.INVISIBILITY);
                actualOrder = getDriver().
                        findElements(By.xpath(candidatesPage.getCurrentSortedColumnXpath()));
                expectedOrder = actualOrder.stream().
                        map((o) -> LocalDate.parse(o.getText(), dateTimeFormatter)).
                        sorted().
                        map((o) -> o.format(dateTimeFormatter)).
                        collect(Collectors.toList());

            } else {
                click(getElementByName(methodName));
                 waitElement(candidatesPage.getPreloader(), WaitCondition.INVISIBILITY);
                actualOrder = getDriver().
                        findElements(By.xpath(candidatesPage.getCurrentSortedColumnXpath()));
                expectedOrder = actualOrder.
                        stream().
                        map((o) -> o.getText().toLowerCase()).
                        sorted().
                        collect(Collectors.toList());
            }
        } else if ("descending".equals(order)) {
            if (tableName.equals("Date Applied")) {
                actualOrder = getDriver().
                        findElements(By.xpath(candidatesPage.getCurrentSortedColumnXpath()));
                expectedOrder = actualOrder.stream().
                        map((o) -> LocalDate.parse(o.getText(), dateTimeFormatter)).
                        sorted(Comparator.reverseOrder()).
                        map((o) -> o.format(dateTimeFormatter)).
                        collect(Collectors.toList());
            } else {
                click(getElementByName(methodName));
                 waitElement(candidatesPage.getPreloader(), WaitCondition.INVISIBILITY);
                click(getElementByName(methodName));
                waitElement(candidatesPage.getPreloader(), WaitCondition.INVISIBILITY);
                actualOrder = getDriver().
                        findElements(By.xpath(candidatesPage.getCurrentSortedColumnXpath()));
                expectedOrder = actualOrder.
                        stream().
                        map((o) -> o.getText().toLowerCase()).
                        sorted(Comparator.reverseOrder()).
                        collect(Collectors.toList());
            }
        }
        assert expectedOrder != null;
        for (int i = 0; i < actualOrder.size(); i++) {
            AssertThatWrapper.assertThat(actualOrder.get(i).getText().compareToIgnoreCase(expectedOrder.get(i)), is(0));
        }
    }

    @And("At least one candidate added")
    public void atLeastOneCandidateAdded() {
        getDriver().getPageSource();
        getDriver().get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/noncore/recruitment/viewCandidates");
        getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
        waitElement(CANDIDATES_PAGE.getPreloader(), WaitCondition.INVISIBILITY);
        firstCandidateInfo = getDriver().findElement(By.xpath("//div[@id='content']/div[8]/div/div[2]/table/tbody/tr")).getText();
        getDriver().get(url);
    }

    @And("User has been deleted")
    public void userHasBeenDeleted() {
        waitElement(CANDIDATES_PAGE.getPreloader(), WaitCondition.INVISIBILITY);
        AssertThatWrapper.assertThat(getDriver().findElement(By.xpath("//div[@id='content']/div[8]/div/div[2]/table/tbody")).
                getText().
                contains(firstCandidateInfo), is(false));
    }
}