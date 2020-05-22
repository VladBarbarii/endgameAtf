@Andrei
Feature: Add New Candidate

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page'

  Scenario: Create new candidate with uploaded resume
    Given The resume file has been prepared
    And User clicks on 'Recruitment' 'tab'
    And User is on 'Vacancies Page'
    And User clicks on 'Navigation' 'menu'
    And User clicks on 'Candidates' 'tab'
    And User is on 'Candidates Page'
    When User clicks on 'Add Candidate' 'button'
    And User enters 'Andrei' in 'First Name' field
    And User enters 'Petrov' in 'Last Name' field
    And User enters 'end@ava.com' in 'Email' field
    And User enters 'Sales Manager' in 'Vacancy' field
    And User clicks on 'Sales Manager' 'option'
    And User enters 'Nice Guy' in 'Note' field
    And User chooses 'resume.txt' from computer
    And User clicks on 'Save' 'button'
    Then 'Successfully Saved' message is displayed
    And New candidate has been added
