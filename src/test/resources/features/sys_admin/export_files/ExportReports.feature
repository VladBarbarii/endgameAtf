Feature: Export Configurations

  Background:
    Given User is logged in as "System Admin"
    And User is on "SystemAdminHomePage" page
    And User clicks on "Leave" "tab"
    And User clicks on "Reports" "tab"
    And User clicks on "Bradford Factor" "tab"

  @Alina
  Scenario Outline: System Admin can export configurations
    When User is on "BradfordFactorPage" page
    And User clicks on "<extension>" "icon"
    And User logout
    Then "<filename>" file is downloaded
    Examples:
      | extension | filename                     |
      | PDF       | Leave Bradford Factor Report |
      | CSV       | Leave+Bradford+Factor+Report |

