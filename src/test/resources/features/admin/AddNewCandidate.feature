
Feature: Add New Candidate

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Dashboard' page

  Scenario: Create new candidate with uploaded resume
    Given The resume file has been prepared
    And User clicks on 'Recruitment' 'tab'
    And User is on 'Vacancies' page
    And User clicks on 'Menu' 'button'
    And User clicks on 'Candidates' 'tab'
    And User is on 'Candidates' page
    When User clicks on 'Add Candidate' 'button'
    And User chooses file from computer
    And User enters 'Andrei' in 'First Name' field
    And User enters 'Petrov' in 'Last Name' field
    And User enters 'end@ava.com' in 'Email' field
    And User enters 'Sales Manager' in 'Vacancy' field
    And User enters 'Nice Guy' in 'Notes' field
    And User clicks on 'SAVE' 'button'
    Then New 'Candidate' has been added
