package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class EmailSettingsPage {
    @FindBy(css = "li:nth-child(2) > span")
    private WebElement smtpMethod;
    @FindBy(css = "li:nth-child(1) > span")
    private WebElement sendingMethod;
    @FindBy(xpath = "//*[@id=\"senderEmail\"]")
    private WebElement senderEmailField;
    @FindBy(xpath = "//*[@id=\"sendingMethod_inputfileddiv\"]/div")
    private WebElement sendingMethodDropdown;
    @FindBy(xpath = "//*[@id=\"mailConfigurationForm\"]/div[1]/materializecss-decorator[6]/div/sf-decorator/div/ul/li[1]/label")
    private WebElement noSecureConnection;
    @FindBy(xpath = "//*[@id=\"mailConfigurationForm\"]/div[1]/materializecss-decorator[7]/div/sf-decorator[1]/div/label")
    private WebElement sendTestEmailCheckbox;
    @FindBy(xpath = "//div[@id='toast-container']/div/div")
    private WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"mailConfigurationForm\"]/div[1]/materializecss-decorator[7]/div/sf-decorator[2]/div/span")
    private WebElement requiredMessageUnderTestEmail;
    @FindBy(xpath = "//*[@id=\"smtpHost\"]")
    private WebElement SMTPHostField;
    @FindBy(xpath = "//*[@id=\"smtpPort\"]")
    private WebElement SMTPPortField;
    @FindBy(xpath = "//*[@id=\"mailConfigurationForm\"]/div[2]/a[2]")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"mailConfigurationForm\"]/div[2]/a[1]")
    private WebElement resetButton;
    public EmailSettingsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getRequiredMessageUnderTestEmail() {
        return requiredMessageUnderTestEmail;
    }

    public WebElement getSendTestEmailCheckbox() {
        return sendTestEmailCheckbox;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getSendingMethod() {
        return sendingMethod;
    }

    public WebElement getSmtpMethod() {
        return smtpMethod;
    }

    public WebElement getSMTPPort() {
        return SMTPPortField;
    }

    public WebElement getSMTPHost() {
        return SMTPHostField;
    }

    public WebElement getSuccessfullySavedMessage() {
        return successMessage;
    }

    public WebElement getNoSecureConnection() {
        return noSecureConnection;
    }

    public WebElement getSenderEmail() {
        return senderEmailField;
    }

    public WebElement getSendingMethodDropdown() {
        return sendingMethodDropdown;
    }

}
