Feature: Negative Add New Work Shift

  Background:
    Given User is logged in as 'System Admin'
    And User is on 'SystemAdminHomePage' page

  @Anna
    @negative
  Scenario Outline: Check that SystemAdmin can not add new work Shift with invalid inputs
    When User clicks on 'Admin1' 'tab'
    And User clicks on 'Job' 'tab'
    And User clicks on 'workShifts' 'tab'
    Then User is on 'WorkShiftsPage' page
    When User clicks on 'Add Work Shift' 'button'
    And User enters '<name>' in 'workShiftField' field
    Then "Should be less than 50 characters" message is displayed on page
    And User clicks on 'cancel' 'button'
    And User logout
    Examples:
      | name                                                                      |
      | The name in this field should be less than 50 characters, but this has 73 |
      | This is a boundary value testing with 51 characters                       |