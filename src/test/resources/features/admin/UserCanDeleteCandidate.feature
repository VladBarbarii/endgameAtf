@Andrei
Feature: User can delete candidate

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page
    And At least one candidate added

  Scenario: User can delete candidate
    When User clicks on 'Recruitment' 'tab'
    And User is on 'Vacancies Page' page
    And User clicks on 'Navigation' 'menu'
    And User clicks on 'Candidates' 'tab'
    And User is on 'Candidates Page' page
    And User clicks on 'Candidate' 'checkbox'
    And User clicks on 'List Actions' 'button'
    And User clicks on 'Delete Item' 'button'
    And User clicks on 'Confirm Delete' 'button'
    Then User has been deleted
    And User logout