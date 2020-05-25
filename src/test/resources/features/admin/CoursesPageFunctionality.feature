@Vlad
Feature: Courses page functionality
  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page
    When User clicks on 'Training' 'tab'
    And User clicks on 'Courses' 'tab'
    Then User is on 'Courses Page' page
  Scenario: User can add a course when at least the mandatory fields are filled
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User enters 'New course title' in 'Title' field
    And User enters 'Kevin Mathews' in 'Coordinator' field
    And User clicks on 'Name' ' '
    And User clicks on 'Save' 'button'
    Then 'Successfully Updated' message is displayed
    And User clicks on 'Courses' 'tab'
    And User is on 'Courses Page' page
    And Course has been added
    And Admin user logs out
  Scenario: User cannot add a course if at least the mandatory fields are not filled
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Save' 'button'
    Then 'Required' message is displayed under each field
    And Admin user logs out
  Scenario: User cannot add a course if invalid fields provided
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User enters 'Async Await in Js' in 'Title' field
    And User enters '^b52d' in "coordinator" field
    And User enters 'ab#d' in "cost" field
    And User clicks on 'save' 'button'
    Then 'Invalid' message is displayed under 'coordinator' field
    And 'Should be a valid number' message is displayed under 'cost' field
    And Admin user logs out
  Scenario: User is able to edit a course
    When User clicks on 'Course' 'name'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User enters 'Docker Training Updated' in "title" field
    And User clicks on 'Save' 'button'
    And User clicks on 'Courses' 'tab'
    And User is on 'Courses Page' page
    Then Course has been updated
    And Admin user logs out
  Scenario: User is able to delete a course
    When User clicks on 'course' 'checkbox'
    And User clicks on 'three dots' 'option'
    And User clicks on 'delete selected' 'option'
    Then 'Modal dialog for delete course' is displayed
    When User clicks on 'yes' 'button'
    Then Course was deleted
    And Admin user logs out