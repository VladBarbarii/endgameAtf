package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class BulkAssignPage {

    @FindBy(xpath = "//*[@id=\"bulkAssignForm\"]/div[2]/div/button")
    private WebElement assignButton;
    @FindBy(xpath = "//*[@id=\"editNotificationModal\"]/form/div[2]/a[2]")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"leaveType_inputfileddiv\"]/span")
    private WebElement requiredMessageUnderLeaveType;
    @FindBy(css = "#bulkAssignForm > div:nth-child(1) > materializecss-decorator:nth-child(2) > div > sf-decorator:nth-child(1) > div > span:nth-child(6)")
    private WebElement requiredMessageUnderFromDate;
    @FindBy(css = "#bulkAssignForm > div:nth-child(1) > materializecss-decorator:nth-child(2) > div > sf-decorator:nth-child(2) > div > span:nth-child(6)")
    private WebElement requiredMessageUnderToDate;
    @FindBy(id = "//*[@id=\"leaveType_inputfileddiv\"]")
    private WebElement leaveTypeDropdown;
    @FindBy(xpath = "//*[@id=\"select-options-70621a65-0d57-6106-e6c8-920f79ad0f19\"]/li[2]")
    private WebElement leaveTypeOption;
    @FindBy(xpath = "")
    private WebElement fromDateCalendarPicker;
    @FindBy(xpath = "")
    private WebElement toDateCalendarPicker;

    public BulkAssignPage() {

        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getLeaveTypeDropdown() {
        return leaveTypeDropdown;
    }

    public WebElement getLeaveTypeOption() {
        return leaveTypeOption;
    }

    public WebElement getFromDateCalendarPicker() {
        return fromDateCalendarPicker;
    }

    public WebElement getToDateCalendarPicker() {
        return toDateCalendarPicker;
    }

    public WebElement getRequiredMessageUnderLeaveType() {
        return requiredMessageUnderLeaveType;
    }

    public WebElement getRequiredMessageUnderFromDate() {
        return requiredMessageUnderFromDate;
    }

    public WebElement getRequiredMessageUnderToDate() {
        return requiredMessageUnderToDate;
    }

    public WebElement getAssignButton() {
        return assignButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

}
