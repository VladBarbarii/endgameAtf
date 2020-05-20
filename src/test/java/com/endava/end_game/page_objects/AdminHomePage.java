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

}
