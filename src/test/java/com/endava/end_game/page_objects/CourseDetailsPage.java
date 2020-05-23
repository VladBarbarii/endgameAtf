package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class CourseDetailsPage {

    public CourseDetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='addCourse_title']")
    private WebElement title;
    @FindBy(id = "addCourse_coordinator_empName")
    private WebElement coordinator;
    @FindBy(id = "btnSaveCourse")
    private WebElement saveButton;
    @FindBy(xpath = "//span[@id='addCourse_coordinator_empName-error']")
    private WebElement requiredMessageUnderTitle;
    @FindBy(id = "addCourse_coordinator_empName-error")
    private WebElement requiredMessageUnderCoordinator;
    @FindBy(xpath = "//li[@class='ac_even ac_over']")
    private WebElement name;
    @FindBy(xpath = "//div[@id='toast-container']/div/div")
    private WebElement successfullyUpdatedMessage;
    @FindBy(xpath = "//*[@id=\"menu_training_viewCourseList\"]/span[2]")
    private WebElement coursesTab;
    @FindBy(id = "addCourse_duration")
    private WebElement duration;
    @FindBy(id = "addCourse_cost")
    private WebElement cost;

    public WebElement getDuration() {
        return duration;
    }

    public WebElement getCost() {
        return cost;
    }

    public WebElement getCoursesTab() {
        return coursesTab;
    }

    public WebElement getSuccessfullyUpdatedMessage() {
        return successfullyUpdatedMessage;
    }

    public WebElement getName() {
        return name;
    }
    public WebElement getRequiredMessageUnderTitle() {
        return requiredMessageUnderTitle;
    }

    public WebElement getRequiredMessageUnderCoordinator() {
        return requiredMessageUnderCoordinator;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getCoordinator() {
        return coordinator;
    }
}
