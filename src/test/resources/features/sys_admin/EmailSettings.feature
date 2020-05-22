Feature: Change Email Settings

  Background:
    Given User is logged in as "System Admin"
    And User is on "SystemAdminHomePage" page
    And User clicks on "Admin" "tab"
    And User clicks on "Configuration" "tab"


  @Alina
  Scenario: User can change email settings providing valid data
    Given User clicks on "Email Settings" "tab"
    And User is on "EmailSettingsPage" page
    And Sending method is SendingMail
    When User clicks on "SendingMethod" "dropdown"
    And User clicks on "SMTP" "method"
    And Choose No option for Use Secure Connection
    And User enters "admin@example.com" in "SenderEmail" field
    And User enters "400" in "SMTPHost" field
    And User enters "465" in "SMTPPort" field
    And User clicks on "Save" "button"
    Then "Successfully Saved" message is displayed
    And User logout

  @Alina
  Scenario: Warning message appear is user try to send test email leaving empty required field
    Given User clicks on "Email Settings" "tab"
    And User is on "EmailSettingsPage" page
    When User clicks on "Send Test Email" "checkbox"
    And User enters "someone@gmail.com" in "SenderEmail" field
    And User clicks on "Save" "button"
    Then "Required" message is displayed under "Test Email" field
    And User logout
