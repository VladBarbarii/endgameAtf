Feature: Edit Job Title

  Background:
    Given User is logged in as 'System Admin'
    And User is on 'SystemAdminHomePage' page

  @Anna
    @positive
  Scenario Outline: Check SystemAdmin can edit job title using valid inputs
    When User clicks on 'Admin1' 'tab'
    And User clicks on 'Job' 'tab'
    And User clicks on 'JobTitles' 'tab'
    Then User is on 'JobTitlesPage' page
    When User clicks on 'EditJobTitle' 'button'
    And User enters '<name>' in 'jobTitleField' field
    And User enters '<description>' in 'jobDescriptionField' field
    And User clicks on 'Save' 'button'
    Then "Successfully Updated" message is displayed on page
    And New '<name>' has been added in JobTitle field
    When User clicks on 'checkBoxJobTitle' 'button'
    And User clicks on 'optionsJobTitle' 'button'
    And User clicks on 'deleteSelected' 'button'
    And User clicks on 'confirmDelete' 'button'
    Then  "Successfully Deleted" message is displayed on page
    And User logout
    Examples:
      | name           | description  |
      | 11 my favorite | just for fun |