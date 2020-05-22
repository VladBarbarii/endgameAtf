Feature: Export leave list report

  Background:
    Given User is logged in as "System Admin"
    And User is on "System Admin Home Page" page
    And User clicks on "Leave" "tab"

  @Alina
  Scenario:System Admin can export Leave List Details report
    When User clicks on "Leave List" "tab"
    And User is on "LeaveListPage" page
    And User clicks on "ExportDetail" "button"
    And User logout
    Then "LeaveListDetailReport" file is downloaded