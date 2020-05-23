package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class AdminHomePage {
    @FindBy(xpath = "//*[@id=\"menu_time_viewTimeModule\"]")
    private WebElement timeTab;
    @FindBy(xpath = "//*[@id=\"menu_time_Timesheets\"]")
    private WebElement timeSheetsTab;
    @FindBy(xpath = "//*[@id=\"menu_time_viewMyTimesheet\"]")
    private WebElement myTimesheetsTab;
    @FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']/span[2]")
    private WebElement recruitmentTab;
    @FindBy(xpath = "//*[@id=\"listOfActivities\"]/timesheet-items-day[1]/div[1]/div[2]/div[1]/a")
    private WebElement addActivityButton;
    @FindBy(xpath = "//*[@id=\"menu_training_defaultTrainingModulePage\"]/a")
    private WebElement trainingTab;
    @FindBy(xpath = "//*[@id=\"menu_training_viewCourseList\"]/span[2]")
    private WebElement coursesTab;

    public AdminHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getTimeSheetsTab() {
        return timeSheetsTab;
    }

    public WebElement getMyTimesheetsTab() {
        return myTimesheetsTab;
    }

    public WebElement getTimeTab() {
        return timeTab;
    }

    public WebElement getRecruitmentTab() {
        return recruitmentTab;
    }

    public WebElement getAddActivityButton() {
        return addActivityButton;
    }
    public WebElement getTrainingTab() {return trainingTab;}
    public WebElement getCoursesTab() {
        return coursesTab;
    }

}
