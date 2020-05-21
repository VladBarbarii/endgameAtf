Feature: Add new bulk assign

  Background:
    Given User is logged in as "System Admin"
    And User is on "System Admin Home Page" page
    And User clicks on "Leave" "tab"

  @Alina
  Scenario:Required message appear under mandatory fields if System Admin try to assign without providing data
    When User clicks on "Bulk Assign" "tab"
    And User is on "Bulk Assign Page" page
    And User clicks on "Assign" "button"
    And User clicks on "Assign" "button"
    Then "Required" message is displayed under "Leave Type" field
    And "Required" message is displayed under "From Date" field
    And "Required" message is displayed under "To Date" field
    And User logout


