@Andrei
Feature: Sort Functional

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page

  Scenario Outline: Sort
    When User clicks on 'Recruitment' 'tab'
    And User is on 'Vacancies Page' page
    And User clicks on 'Navigation' 'menu'
    And User clicks on 'Candidates' 'tab'
    And User is on 'Candidates Page' page
    And Sort table by '<table_name>' in '<order>' order
    And User logout
    Examples:
      | table_name     | order      |
      | Vacancy        | ascending  |
      | Vacancy        | descending |
      | Candidate      | ascending  |
      | Candidate      | descending |
      | Email          | ascending  |
      | Email          | descending |
      | Contact Number | ascending  |
      | Contact Number | descending |
      | Date Applied   | ascending  |
      | Date Applied   | descending |