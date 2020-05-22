Feature: Negative Add New Job Title

  Background:
    Given User is logged in as 'System Admin'
    And User is on 'SystemAdminHomePage' page

  @Anna
    @negative
  Scenario Outline: Check SystemAdmin can not add new job title with invalid inputs
    When User clicks on 'Admin1' 'tab'
    And User clicks on 'Job' 'tab'
    And User clicks on 'JobTitles' 'tab'
    Then User is on 'JobTitlesPage' page
    When User clicks on 'AddNewJobTitle' 'button'
    And User enters '<name>' in 'jobTitleField' field
    Then "Should be less than 100 characters" message is displayed on page
    And User clicks on 'Cancel' 'button'
    And User logout
    Examples:
      | name                                                                                                                       |
      | Name Should be less then 100 characters, but this name has 122 characters, it is equivalence partitioning negative testing |
      | Name Should be less then 100 characters, but this name has 101 it is boundary values negative testing                      |