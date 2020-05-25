package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class RecruitmentMenuPage  {
    @FindBy(xpath = "//div[@id='content']/div[5]/nav/div/a/i")
    private WebElement navigationMenu;
    @FindBy(xpath = "//a[contains(text(),'Candidates')]")
    private WebElement candidatesTab;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeTab;

    public RecruitmentMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getNavigationMenu() {
        return navigationMenu;
    }

    public WebElement getCandidatesTab() {
        return candidatesTab;
    }

    public WebElement getHomeTab() {
        return homeTab;
    }
}
