package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class SystemAdminHomePage {
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div[4]/ul/li[1]/a/span[2]")
    private WebElement adminTab;
    @FindBy(xpath = "//*[@id=\"menu_admin_Configuration\"]")
    private WebElement configurationTab;

    @FindBy(xpath = "//*[@id=\"menu_admin_listMailConfiguration\"]/span[2]")
    private WebElement emailSettingsTab;
    @FindBy(xpath = "//*[@id=\"menu_admin_exportConfiguration\"]")
    private WebElement exportTab;
    @FindBy(xpath = "//*[@id=\"menu_bulkdata_ManagementTools\"]/a/span[2]")
    private WebElement managementToolsTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_bulkAssignLeave\"]")
    private WebElement bulkAssignTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_viewLeaveModule\"]")
    private WebElement leaveTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_viewLeaveList\"]")
    private WebElement leaveListTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_Configure\"]/a/span[2]")
    private WebElement configureTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_viewLeaveNotifications\"]/span[2]")
    private WebElement notificationsTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_Reports\"]")
    private WebElement reportsTab;
    @FindBy(xpath = "//*[@id=\"menu_leave_viewBradfordFactorReport\"]")
    private WebElement bradfordFactorTab;
    @FindBy(xpath = "//*[@id=\"logoutLink\"]")
    private WebElement logOutButton;
    @FindBy(xpath = "//*[@id=\"user-dropdown\"]")
    private WebElement systemAdminTab;
    public SystemAdminHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getLeaveListTab() {
        return leaveListTab;
    }

    public WebElement getBulkAssignTab() {
        return bulkAssignTab;
    }

    public WebElement getNotificationsTab() {
        return notificationsTab;
    }

    public WebElement getConfigureTab() {
        return configureTab;
    }

    public WebElement getReportsTab() {
        return reportsTab;
    }

    public WebElement getBradfordFactorTab() {
        return bradfordFactorTab;
    }

    public WebElement getLeaveTab() {
        return leaveTab;
    }

    public WebElement getManagementToolsTab() {
        return managementToolsTab;
    }

    public WebElement getExportTab() {
        return exportTab;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getSystemAdminTab() {
        return systemAdminTab;
    }

    public WebElement getAdminTab() {
        return adminTab;
    }

    public WebElement getConfigurationTab() {
        return configurationTab;
    }

    public WebElement getEmailSettingsTab() {
        return emailSettingsTab;
    }
}
