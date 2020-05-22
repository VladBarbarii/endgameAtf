Feature: Add New Work Shift

  Background:
    Given User is logged in as 'System Admin'
    And User is on 'SystemAdminHomePage' page

  @Anna
    @positive
  Scenario Outline: Check that SystemAdmin can add new work Shift with valid inputs
    When User clicks on 'Admin1' 'tab'
    And User clicks on 'Job' 'tab'
    And User clicks on 'workShifts' 'tab'
    Then User is on 'WorkShiftsPage' page
    When User clicks on 'Add Work Shift' 'button'
    And User enters '<name>' in 'workShiftField' field
    And User enters '11:00' in 'timeFromField' field
    And User enters '15:00' in 'timeToField' field
    And User clicks on 'saveAddWorkShift' 'button'
    Then "Successfully Saved" message is displayed on page
    And New work shift '<name>' has been added
    When User clicks on 'checkBoxWorkShift' 'button'
    And User clicks on 'optionsWorkShift' 'button'
    And User clicks on 'deleteSelectedWorkShift' 'button'
    And User clicks on 'confirmDelete' 'button'
    Then  "Successfully Deleted" message is displayed on page
    And User logout
    Examples:
      | name               |
      | a first work shift |