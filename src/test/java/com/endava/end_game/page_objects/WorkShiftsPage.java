package com.endava.end_game.page_objects;

import com.endava.end_game.ScenarioContext;
import com.endava.end_game.ScenarioKeys;
import com.endava.end_game.web_driver_singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class WorkShiftsPage {

    @FindBy(xpath = "//*[@id=\"workShiftDiv\"]/div/a/i")
    private WebElement addWorkShiftButton;
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement workShiftField;
    @FindBy(xpath = "//*[@id=\"start_time\"]")
    private WebElement timeFromField;
    @FindBy(xpath = "//*[@id=\"end_time\"]")
    private WebElement timeToField;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[2]/a[1]")
    private WebElement saveAddWorkShiftButton;
    @FindBy(xpath = "//*[@id=\"workShiftDiv\"]/crud-panel/div/div/list/table/tbody/tr[1]/td[1]/label")
    private WebElement checkBoxWorkShiftButton;
    @FindBy(xpath = "//*[@id=\"workShiftDiv\"]/crud-panel/div/div/list/table/thead/tr/th[1]/a/i")
    private WebElement optionsWorkShiftButton;
    @FindBy(css = "#listdirective-options-dropdown-list0-action-deleteSelection\\} > a")
    private WebElement deleteSelectedWorkShiftButton;
    @FindBy(xpath = " //*[@id=\"delete_confirmation_modal\"]/div[2]/a[2]")
    private WebElement confirmDeleteButton;
    @FindBy(css = ".toast-message")
    private WebElement successfullySavedMessage;
    @FindBy(css = ".toast-message")
    private WebElement successfullyDeletedMessage;
    @FindBy(xpath = "//*[@id=\"workShiftDiv\"]/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span")
    private List<WebElement> workShiftNames;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[2]/a[2]")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"modal1\"]/form/div[1]/div/materializecss-decorator[1]/div/sf-decorator[1]/div/span")
    private WebElement shouldBeLessThan50CharactersMessage;

    public WorkShiftsPage() {PageFactory.initElements(getDriver(), this);}

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getShouldBeLessThan50CharactersMessage() {
        return shouldBeLessThan50CharactersMessage;
    }

    public WebElement getAddWorkShiftButton() {
        return addWorkShiftButton;
    }

    public WebElement getSaveAddWorkShiftButton() {
        return saveAddWorkShiftButton;
    }

    public WebElement getCheckBoxWorkShiftButton() {
        return checkBoxWorkShiftButton;
    }

    public WebElement getOptionsWorkShiftButton() {
        return optionsWorkShiftButton;
    }

    public WebElement getDeleteSelectedWorkShiftButton() {
        return deleteSelectedWorkShiftButton;
    }

    public WebElement getWorkShiftField() {
        return workShiftField;
    }

    public WebElement getConfirmDeleteButton() {
        return confirmDeleteButton;
    }

    public WebElement getTimeFromField() {
        return timeFromField;
    }

    public WebElement getTimeToField() {
        return timeToField;
    }

    public WebElement getSuccessfullySavedMessage() {
        return successfullySavedMessage;
    }

    public List<WebElement> getWorkShiftNames() {
        return workShiftNames;
    }

    static ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public void getWorkShift(int id) {
        scenarioContext.saveData(ScenarioKeys.WORKSHIFT, workShiftNames.get(0).getText());
    }

    public WebElement getSuccessfullyDeletedMessage() {
        return successfullyDeletedMessage;
    }
}