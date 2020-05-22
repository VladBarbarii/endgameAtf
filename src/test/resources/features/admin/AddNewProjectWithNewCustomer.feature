Feature: Add New Project With New Customer

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page

  Scenario: Fill in all fields in the form
    When User clicks on 'Time' 'tab'
    And User clicks on 'Activity Info' 'tab'
    And User clicks on 'Projects' 'tab'
    Then User is on 'Projects Page' page

    When User clicks on 'Add Project' 'button'
    And User enters 'MyProject' in 'Name' field
    And User enters 'MyDescription' in 'Description' field
    And User clicks on 'Add New Customer' 'option'
    And User enters 'MyCustomer' in 'Customer Name' field
    And User enters 'Customer Cost Center' in '0004 - Cost Center (Sales)' field
    And User enters 'MyCustomer Description' in 'Customer Description' field
    And User clicks on 'SAVE' 'button'
    Then New 'Customer' has been added
    And New 'Project' has been added