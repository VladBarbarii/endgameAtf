package com.endava.end_game.steps;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.CourseDetailsPage;
import com.endava.end_game.page_objects.CoursesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.endava.end_game.AssertThatWrapper.assertThat;
import static com.endava.end_game.steps.GenericActions.waitElement;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class TestStepsVlad {

    @Then("Course has been added")
    public void courseHasBeenAdded() {
        CoursesPage coursesPage = (CoursesPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        List<String> coursesTitles = coursesPage.getCoursesNames().stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("list contains the title of a newly added course, hence the course was created", coursesTitles, contains("New course title"));
    }

    @Then("The options are sorted {string} by {string}")
    public void theOptionsAreSortedBy(String sorting, String option) {
        CoursesPage coursesPage = (CoursesPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        List<String> coursesTitles = coursesPage.getCoursesNames().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> companyNames = coursesPage.getCompanyNames().stream().map(WebElement::getText).collect(Collectors.toList());
        switch (option) {
            case "company":
                if ("ascending".equals(sorting)) {
                    assertThat("company names are sorted asc", companyNames, is(companyNames.stream().sorted().collect(Collectors.toList())));
                } else {
                    assertThat("company names are sorted desc", companyNames, is(companyNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())));
                }
                break;
            case "title":
                if ("ascending".equals(sorting)) {
                    assertThat("course titles are sorted asc", coursesTitles, is(coursesTitles.stream().sorted().collect(Collectors.toList())));
                } else {
                    assertThat("course titles are sorted desc", coursesTitles, is(coursesTitles.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())));
                }
        }
    }

    @Then("{string} message is displayed under each field")
    public void requiredMessageIsDisplayedUnderEachField(String message) {
        CourseDetailsPage courseDetailsPage = (CourseDetailsPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        GeneralSteps generalSteps = new GeneralSteps();
        waitElement(courseDetailsPage.getRequiredMessageUnderCoordinator(), GenericActions.WaitCondition.VISIBILITY);
        generalSteps.messageIsDisplayedUnderField(message, "coordinator");
        generalSteps.messageIsDisplayedUnderField(message, "title");
    }
}

