package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class CoursesPage {

    public CoursesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"user-dropdown\"]")
    private WebElement systemAdminTab;
    @FindBy(xpath = "//*[@id=\"addItemBtn\"]/i")
    private WebElement addButton;
    @FindBy(css = ".dataRaw>:nth-child(2)")
    private List<WebElement> coursesNames;
    @FindBy(css = ".dataRaw>td:nth-child(1)>label")
    private List<WebElement> coursesCheckboxes;
    @FindBy(css = ".dataRaw>:nth-child(5)")
    private List<WebElement> companyNames;
    @FindBy(xpath = "//a[contains(text(),'Company')]")
    private WebElement companyOption;
    @FindBy(xpath = "//a[contains(text(),'Title')]")
    private WebElement titleOption;
    @FindBy(xpath = "//*[@id=\"logoutLink\"]")
    private WebElement logOutButton;
    @FindBy(xpath = "//tr[1]//td[2]")
    private WebElement forTest;
    @FindBy(css = ".dataRaw:nth-child(1) label")
    private WebElement courseCheckbox;
    @FindBy(xpath = "//*[@id=\"frmList_ohrmListComponent_Menu\"]/i")
    private WebElement threeDotsOption;
    @FindBy(id = "deleteBtn")
    private WebElement deleteSelectedOption;
    @FindBy(xpath = "//*[@id=\"course-delete-button\"]")
    private WebElement yesButton;
    @FindBy(id = "course-delete-button")
    private WebElement modalDialogForDeleteCourse;
    @FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")
    private WebElement courseName;

    public WebElement getCourseName() {
        return courseName;
    }

    public List<WebElement> getCoursesCheckboxes() {
        return coursesCheckboxes;
    }

    public WebElement getModalDialogForDeleteCourse() {
        return modalDialogForDeleteCourse;
    }

    public WebElement getYesButton() {
        return yesButton;
    }

    public WebElement getDeleteSelectedOption() {
        return deleteSelectedOption;
    }

    public WebElement getThreeDotsOption() {
        return threeDotsOption;
    }

    public WebElement getCourseCheckbox() {
        return courseCheckbox;
    }

    public WebElement getForTest() {
        return forTest;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getSystemAdminTab() {
        return systemAdminTab;
    }

    public WebElement getTitleOption() {
        return titleOption;
    }

    public WebElement getCompanyOption() {
        return companyOption;
    }

    public List<WebElement> getCompanyNames() {
        return companyNames;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public List<WebElement> getCoursesNames() {
        return coursesNames;
    }
}