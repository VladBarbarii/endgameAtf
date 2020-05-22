package com.endava.end_game.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.steps.GenericActions.click;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class CandidatesPage extends RecruitmentMenuPage {
    private WebElement clickable;
    private String nameValue = "Andrei Petrov";
    @FindBy(xpath = "//a[@id='addItemBtn']/i")
    private WebElement addCandidateButton;
    @FindBy(xpath = "//input[@id='addCandidate_resume']")
    private WebElement selectResume;
    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='addCandidate_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='addCandidate_contactNo']")
    private WebElement contactNumber;
    @FindBy(xpath = "(//input[@type='text'])[10]")
    private WebElement vacancy;
    @FindBy(xpath = "//textarea[@id='addCandidate_managerNote']")
    private WebElement note;
    @FindBy(xpath = "//a[contains(text(),'Cancel')]")
    private WebElement cancel;
    @FindBy(xpath = "//a[@id='saveCandidateButton']")
    private WebElement saveButton;
    @FindBy(xpath = "//p[contains(.,'Sales Manager')]")
    private WebElement salesManagerOption;
    @FindBy(xpath = "//div[@id='toast-container']/div/div")
    private WebElement successfullySavedMessage;
    @FindBy(xpath = "//a[@id='candidateSearchBtn']/i")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement searchField;

    public WebElement getSalesManagerOption() {
        return salesManagerOption;
    }

    public CandidatesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getAddCandidateButton() {
        return addCandidateButton;
    }

    public WebElement getSelectResume() {
        return selectResume;
    }

    public WebElement getFirstName() {
        clickable = getElementByXpath("//label[contains(.,'First Name *')]");
        click(clickable);
        return firstName;
    }

    public WebElement getLastName() {
        clickable = getElementByXpath("//label[contains(.,'Last Name *')]");
        click(clickable);
        return lastName;
    }

    public WebElement getEmail() {
        clickable = getElementByXpath("//label[contains(.,'E-mail *')]");
        click(clickable);
        return email;
    }

    public WebElement getContactNumber() {
        clickable = getElementByXpath("//label[contains(.,'Contact Number')]");
        click(clickable);
        return contactNumber;
    }

    public WebElement getVacancy() {
        clickable = getElementByXpath("//label[contains(.,'Vacancy')]");
        click(clickable);
        return vacancy;
    }

    public WebElement getNote() {
        return note;
    }

    public WebElement getCancel() {
        return cancel;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    private WebElement getElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public WebElement getSuccessfullySavedMessage() {
        return successfullySavedMessage;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }
    public String getNameValue() {
        return nameValue;
    }
}
