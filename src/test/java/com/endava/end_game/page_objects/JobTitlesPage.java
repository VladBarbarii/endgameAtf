package com.endava.end_game.page_objects;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class JobTitlesPage {

    @FindBy(xpath = "//*[@id=\"jobTitlesDiv\"]/div/a/i")
    private WebElement addNewJobTitleButton;
    @FindBy(xpath = "//*[@id=\"jobTitleName\"]")
    private WebElement jobTitleField;
    @FindBy(xpath = "//*[@id=\"modal1\"]/h4")
    private WebElement jobTitleText;
    @FindBy(xpath = "//*[@id=\"jobDescription\"]")
    private WebElement jobDescriptionField;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[2]/a[1]")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id='jobTitlesDiv']/crud-panel/div/div/list/table/tbody/tr/td/label")
    private WebElement checkBoxJobTitleButton;
    @FindBy(xpath = "//*[@id=\"jobTitlesDiv\"]/crud-panel/div/div/list/table/thead/tr/th[1]/a")
    private WebElement optionsJobTitleButton;
    @FindBy(css = "#listdirective-options-dropdown-list0-action-deleteSelection\\} > a")
    private WebElement deleteSelectedButton;
    @FindBy(xpath = "//*[@id=\"delete_confirmation_modal\"]/div[2]/a[2]")
    private WebElement confirmDeleteButton;
    @FindBy(css = ".toast-message")
    private WebElement successfullySavedMessage;
    @FindBy(xpath = "//*[@id=\"jobTitlesDiv\"]/crud-panel/div/div/list/table/tbody/tr[1]/td[4]/i")
    private WebElement editJobTitleButton;
    @FindBy(css = ".toast-message")
    private WebElement successfullyUpdatedMessage;
    @FindBy(css = ".toast-message")
    private WebElement successfullyDeletedMessage;
    @FindBy(xpath = "//*[@id=\"jobTitlesDiv\"]/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span")
    private List<WebElement> jobTitles;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[1]/div/materializecss-decorator[1]/div/sf-decorator[1]/div/span")
    private WebElement shouldBeLessThan100CharactersMessage;
    @FindBy(xpath = "//*[@id=\"jobTitlesDiv\"]/crud-panel/div/div/list/table/tbody/tr[1]/td[4]")
    private WebElement editButton;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[2]/a[2]")
    private WebElement cancelButton;

    public JobTitlesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getEditButton() {return editButton;}

    public WebElement getCancelButton() {return cancelButton;}

    public WebElement getShouldBeLessThan100CharactersMessage() {
        return shouldBeLessThan100CharactersMessage;
    }

    public WebElement getAddNewJobTitleButton() {
        return addNewJobTitleButton;
    }

    public WebElement getJobTitleField() {
        return jobTitleField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getCheckBoxJobTitleButton() {
        return checkBoxJobTitleButton;
    }

    public WebElement getOptionsJobTitleButton() {
        return optionsJobTitleButton;
    }

    public WebElement getDeleteSelectedButton() {
        return deleteSelectedButton;
    }

    public WebElement getConfirmDeleteButton() {
        return confirmDeleteButton;
    }

    public WebElement getJobDescriptionField() {
        return jobDescriptionField;
    }

    public WebElement getSuccessfullySavedMessage() {return successfullySavedMessage;}

    public WebElement getSuccessfullyDeletedMessage() {return successfullyDeletedMessage;}

    public WebElement getEditJobTitleButton() {
        return editJobTitleButton;
    }

    public WebElement getSuccessfullyUpdatedMessage() {
        return successfullyUpdatedMessage;
    }

    public List<WebElement> getJobTitles() {
        return jobTitles;
    }

    static ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public void getJobTitle(int id) {
        scenarioContext.saveData(ScenarioKeys.JOBTITLE, jobTitles.get(0).getText());
    }
}