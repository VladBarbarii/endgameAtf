package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.steps.GenericActions.WaitCondition;
import static com.endava.end_game.steps.GenericActions.waitElement;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class MyTimesheetsPage {
    @FindBy(xpath = "//*[@id=\"listOfActivities\"]/timesheet-items-day[1]/div[1]/div[2]/div[1]/a")
    private WebElement addActivityButton;
    @FindBy(xpath = "//*[@id=\"projectId_value\"]")
    private WebElement project;
    @FindBy(xpath = "//div[@id='activityId_inputfileddiv']/div")
    private WebElement activityDropDown;
    @FindBy(xpath = "//div[2]/materializecss-decorator/div/div/ul/li[8]/span")
    private WebElement meetingOption;
    @FindBy(xpath = "//input[@id='startTime']")
    private WebElement from;
    @FindBy(xpath = "//input[@id='endTime']")
    private WebElement to;
    @FindBy(xpath = "//div[@id='listOfActivities']/timesheet-items-day/div/timesheet-item/div/div/div/i")
    private WebElement addCommentButton;
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement comment;
    @FindBy(xpath = "(//a[contains(text(),'Save')])[2]")
    private WebElement saveCommentButton;
    @FindBy(xpath = "//a[contains(text(),'Save')]")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id='toast-container']/div/div")
    private WebElement successfullySavedMessage;
    @FindBy(xpath = "//*[@id=\"listOfActivities\"]/timesheet-items-day[1]/div[1]/timesheet-item/div/div[1]/div[1]")
    private WebElement projectLine;
    @FindBy(xpath = "//div[@id='projectId_dropdown']/div[3]/div")
    private WebElement firstOption;
    @FindBy(xpath = "//div[@id='preloader']")
    private WebElement preloader;
    @FindBy(xpath="//span[contains(.,'Required')]")
    private WebElement requiredMessageUnderActivity;
    @FindBy(xpath = "//div[3]/materializecss-decorator/div/span/span[2]")
    private WebElement requiredMessageUnderTo;

    @FindBy(xpath = "//div[3]/materializecss-decorator/div/span/span[2]")
    private WebElement requiredMessageUnderFrom;

    public MyTimesheetsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getRequiredMessageUnderActivity() {
        return requiredMessageUnderActivity;
    }

    public WebElement getRequiredMessageUnderTo() {
        return requiredMessageUnderTo;
    }

    public WebElement getRequiredMessageUnderFrom() {
        return requiredMessageUnderFrom;
    }

    public WebElement getAddActivityButton() {
        return addActivityButton;
    }

    public WebElement getProject() {
        return project;
    }

    public WebElement getActivityDropDown() {
        waitElement(getPreloader(), WaitCondition.INVISIBILITY);
        return activityDropDown;
    }

    public WebElement getMeetingOption() {
        return meetingOption;
    }

    public WebElement getFrom() {
        return from;
    }

    public WebElement getTo() {
        return to;
    }

    public WebElement getAddCommentButton() {
        return addCommentButton;
    }

    public WebElement getComment() {
        return comment;
    }

    public WebElement getSaveCommentButton() {
        return saveCommentButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getSuccessfullySavedMessage() {
        return successfullySavedMessage;
    }

    public WebElement getProjectLine() {
        return projectLine;
    }

    public WebElement getFirstOption() {
        return firstOption;
    }

    public WebElement getPreloader() {
        return preloader;
    }
}
