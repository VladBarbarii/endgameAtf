package com.endava.end_game.steps;

import com.endava.end_game.page_objects.JobTitlesPage;
import com.endava.end_game.page_objects.WorkShiftsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.endava.end_game.AssertThatWrapper.assertThat;
import static org.hamcrest.Matchers.contains;


public class TestStepsAnna {
    @Then("New work shift {string} has been added")
    public static void newElementHasBeenAdded(String newWorkShift) {
        WorkShiftsPage workShiftsPage = new WorkShiftsPage();
        workShiftsPage.getWorkShift(0);
        List<String> workShifts = workShiftsPage.getWorkShiftNames().stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("assert that new Work Shift has been added ", workShifts, contains(newWorkShift));
    }

    @Then("New {string} has been added in JobTitle field")
    public void newNameHasBeenAddedInJobTitleField(String nameToFind) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage();
        jobTitlesPage.getJobTitle(0);
        List<String> workShifts = jobTitlesPage.getJobTitles().stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("assert that new Job Title nas been added", workShifts, contains(nameToFind));
    }
}