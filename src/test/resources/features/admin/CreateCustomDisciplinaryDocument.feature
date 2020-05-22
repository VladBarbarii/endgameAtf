
Feature: Create Custom Disciplinary Document

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Dashboard'

  Scenario: Fill in only mandatory fields
    When User clicks on 'Discipline' 'tab'
    And User clicks on 'Configuration' 'tab'
    And User clicks on 'Document Templates' 'tab'
    Then User is on 'Disciplinary Document Templates'

    When User clicks on 'Add Document Template' 'button'
    Then User is on 'Add Disciplinary Document Template'

    When User enters 'MyTerminate' in 'Name' field
    And User clicks on 'Link to action' 'drop down'
    And User chooses 'Terminate' option
    And User clicks on 'Save' 'button'
    Then New 'Document Template' has been added

    When User clicks on 'Discipline' 'tab'
    Then User is on 'Disciplinary Cases'

    When User clicks on 'Case Name' 'link'
    And User clicks on 'TAKE DISCIPLINARY ACTION' 'button'
    And User chooses 'Terminate' option
    And User clicks on 'Select' 'button'
    Then User is on 'Add Action'

    When User enters 'Brody Alan' in 'Owner' field
    And User clicks on 'Status' 'drop down'
    And User chooses 'Open' option
    And User clicks on 'SAVE' 'Button'
    And User clicks on 'CREATE DOCUMENT' 'button'
    And User chooses 'MyTerminate' option
    And User clicks on 'SELECT' 'button'
    Then User is on 'Document'
#  ????


#      All is hardcoded is it ok?
#      Do we need value for button, link, tab?

