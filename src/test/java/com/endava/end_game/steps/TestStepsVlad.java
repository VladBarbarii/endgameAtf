package com.endava.end_game.steps;
import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.page_objects.CourseDetailsPage;
import com.endava.end_game.page_objects.CoursesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.endava.end_game.AssertThatWrapper.assertThat;
import static com.endava.end_game.steps.GenericActions.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class TestStepsVlad {
    private static final CoursesPage coursesPage = new CoursesPage();
    @Then("Course has been added")
    public void courseHasBeenAdded() {
        List<String> coursesTitles = listOfCoursesOnThePage();
        assertThat("list containsTitle the title of a newly added course, hence the course was created", coursesTitles, hasItem("New course title"));
    }
    @Then("{string} message is displayed under each field")
    public void requiredMessageIsDisplayedUnderEachField(String message) {
        CourseDetailsPage courseDetailsPage = (CourseDetailsPage) ScenarioContext.getInstance().getData(ScenarioKeys.PAGE);
        GeneralSteps generalSteps = new GeneralSteps();
        waitElement(courseDetailsPage.getRequiredMessageUnderCoordinator(), GenericActions.WaitCondition.VISIBILITY);
        generalSteps.messageIsDisplayedUnderField(message, "coordinator");
        generalSteps.messageIsDisplayedUnderField(message, "title");
    }
    @Then("Admin user logs out")
    public void adminUserLogsOut() {
        CourseDetailsPage courseDetailsPage = new CourseDetailsPage();
        click(courseDetailsPage.getSystemAdminTab());
        click(courseDetailsPage.getLogOutButton());
    }
    @Then("{string} is displayed")
    public void elementIsDisplayed(String elementName) {
        GeneralSteps generalSteps = new GeneralSteps();
        String methodName = "get" + elementName;
        waitElement(getElementByName(methodName), GenericActions.WaitCondition.VISIBILITY);
    }
    @Then("Course was deleted")
    public void courseWasDeleted() {
        List<String> coursesTitless = listOfCoursesOnThePage();
        assertThat("list does not contain the title of the deleted course, hence the course was created", coursesTitless, not(hasItem("Docker Training Updated")));
    }
    @Then("Course has been updated")
    public void courseHasBeenUdpated() {
        List<String> coursesTitles = listOfCoursesOnThePage();
        assertThat("list the course with the updated title, hence the course was updated", coursesTitles, hasItem("Docker Training Updated"));
    }
    public List<String> listOfCoursesOnThePage() {
        return coursesPage.getCoursesNames().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}