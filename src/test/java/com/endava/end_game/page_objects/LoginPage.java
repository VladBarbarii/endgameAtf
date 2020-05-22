package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"loginAsButtonGroup\"]/button")
    private WebElement loginRoleButton;
    @FindBy(xpath = "//*[@id=\"loginAsButtonGroup\"]/ul/li[1]/a")
    private WebElement systemAdminTab;
    @FindBy(xpath = "//*[@id=\"loginAsButtonGroup]\"/ul/li[2]/a")
    private WebElement adminTab;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getLoginRoleButton() {
        return loginRoleButton;
    }

    public WebElement getSystemAdminTab() {
        return systemAdminTab;
    }

    public WebElement getAdminTab() {
        return adminTab;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }


}
