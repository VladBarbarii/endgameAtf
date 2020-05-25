package com.endava.end_game.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.steps.GenericActions.click;
import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class CandidatesPage extends RecruitmentMenuPage {
    private WebElement clickable;
    private static String currentSortedColumnXpath = "//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[6]";
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
    private WebElement searchMenu;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement searchField;
    @FindBy(xpath = "//a[contains(text(),'Search')]")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/thead/tr/th[2]")
    private WebElement sortByVacancy;
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/thead/tr/th[3]")
    private WebElement sortByCandidate;
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/thead/tr/th[4]")
    private WebElement sortByEmail;
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/thead/tr/th[5]")
    private WebElement sortByContactNumber;
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/thead/tr/th[6]")
    private WebElement sortByDateApplied;
    @FindBy(xpath = "//div[@id='preloderDiv']")
    private WebElement preloader;
    @FindBy(xpath = "//i[@onclick=\"window.location.href = '/recruitment/exportCandidateApplicationFormPdf?candidateId=132'\"]")
    private WebElement downloadApplicationFormButton;//unuseful
    @FindBy(xpath = "//div[@id='content']/div[8]/div/div[2]/table/tbody/tr/td/label")
    private WebElement candidateCheckbox;
    @FindBy(xpath = "//a[@id='ohrmList_Menu']/i")
    private WebElement listActionsButton;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    private WebElement deleteItemButton;
    @FindBy(xpath = "//a[contains(text(),'yes, delete')]")
    private WebElement confirmDeleteButton;

    public CandidatesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getSalesManagerOption() {
        return salesManagerOption;
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
        return (getDriver()).findElement(By.xpath(xpath));
    }

    public WebElement getSuccessfullySavedMessage() {
        return successfullySavedMessage;
    }

    public WebElement getSearchMenu() {
        return searchMenu;
    }

    public WebElement getSearchField() {
        return searchField;
    }


    public String getNameValue() {
        return nameValue;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSortByVacancy() {
        setCurrentSortedColumnXpath("//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[2]");
        return sortByVacancy;
    }

    public WebElement getSortByCandidate() {
        setCurrentSortedColumnXpath("//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[3]");
        return sortByCandidate;
    }

    public WebElement getSortByEmail() {
        setCurrentSortedColumnXpath("//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[4]");
        return sortByEmail;
    }

    public WebElement getSortByContactNumber() {
        setCurrentSortedColumnXpath("//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[5]");
        return sortByContactNumber;
    }

    public WebElement getSortByDateApplied() {
        setCurrentSortedColumnXpath("//*[@id=\"content\"]/div[8]/div/div[2]/table/tbody/tr/td[6]");
        return sortByDateApplied;
    }

    public WebElement getPreloader() {
        return preloader;
    }

    public String getCurrentSortedColumnXpath() {
        return currentSortedColumnXpath;
    }

    public void setCurrentSortedColumnXpath(String currentSortedColumnXpath) {
        CandidatesPage.currentSortedColumnXpath = currentSortedColumnXpath;
    }

    public WebElement getDownloadApplicationFormButton() {
        return downloadApplicationFormButton;
    }

    public WebElement getCandidateCheckbox() {
        return candidateCheckbox;
    }

    public WebElement getListActionsButton() {
        return listActionsButton;
    }

    public WebElement getDeleteItemButton() {
        return deleteItemButton;
    }

    public WebElement getConfirmDeleteButton() {
        return confirmDeleteButton;
    }
}