@Andrei
Feature: Add Timesheet Activity

  Background:
    Given User is logged in as 'Admin'
    And User is on 'AdminHomePage' page

  Scenario: Check all positive flow
    When User clicks on 'Time' 'tab'
    And User clicks on 'Timesheets' 'tab'
    And User clicks on 'My Timesheets' 'tab'
    Then User is on 'AdminHomePage' page
    When User clicks on 'Add Activity' 'button'
    And User enters 'ACME Ltd - Sales' in 'Project' field
    And User clicks on 'Activity' 'drop down'
    And User chooses 'Bug Fixing' option
    And User enters '09:45' in 'From' field
    And User enters '10:45' in 'To' field
    Then New 'Activity' has been added