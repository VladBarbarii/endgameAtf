@Andrei
Feature: Add Timesheet Activity

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page

  Scenario: Add empty activity
    When User clicks on 'Time' 'tab'
    And User clicks on 'Timesheets' 'tab'
    And User clicks on 'My Timesheets' 'tab'
    And User is on 'My Timesheets Page' page
    And User clicks on 'Add Activity' 'button'
    And User clicks on 'Save' 'button'
    Then 'Required' message is displayed under 'Activity' field
    And 'Required' message is displayed under 'From' field
    And 'Required' message is displayed under 'To' field
    And User logout

  Scenario: Add first activity
    Given There is no 'Activity' added
    When User clicks on 'Time' 'tab'
    And User clicks on 'Timesheets' 'tab'
    And User clicks on 'My Timesheets' 'tab'
    And User is on 'My Timesheets Page' page
    And User clicks on 'Add Activity' 'button'
    And User enters 'ACME' in 'Project' field
    And User clicks on 'First' 'option'
    And User clicks on 'Activity' 'drop down'
    And User clicks on 'Meeting' 'option'
    And User enters '09:45' in 'From' field
    And User enters '10:45' in 'To' field
    And User clicks on 'Add Comment' 'button'
    And User enters 'Something interesting' in 'comment' field
    And User clicks on 'Save Comment' 'button'
    And User clicks on 'Save' 'button'
    Then 'Successfully Saved' message is displayed
    And New activity has been added
    And User logout