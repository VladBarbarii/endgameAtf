package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class LeaveListPage {
    public WebElement getExportDetailButton() {
        return exportDetailButton;
    }

    @FindBy(xpath = "//*[@id=\"searchLeaveList\"]/div[2]/div/a[3]")
    private WebElement exportDetailButton;

    public LeaveListPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
