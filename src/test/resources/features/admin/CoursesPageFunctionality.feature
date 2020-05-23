@Vlad
Feature: Courses page functionality

  Background:
    Given User is logged in as 'Admin'
    And User is on 'Admin Home Page' page
    When User clicks on 'Training' 'tab'
    And User clicks on 'Courses' 'tab'
    Then User is on 'Courses Page' page

  Scenario: User can add a course when at least the mandatory fields are filled
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User enters 'New course title' in 'Title' field
    And User enters 'Kevin Mathews' in 'Coordinator' field
    And User clicks on 'Name' ' '
    And User clicks on 'Save' 'button'
    Then 'Successfully Updated' message is displayed
    And User clicks on 'Courses' 'tab'
    And User is on 'Courses Page' page
    And Course has been added

  Scenario: User cannot add a course if at least the mandatory fields are not filled
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User clicks on 'Save' 'button'
    Then 'Required' message is displayed under each field

  Scenario Outline: Sort by <Option>
    When User clicks on "<Option>" 'option'
    Then The options are sorted "<Sorting>" by "<Option>"
    Examples:
      | Option  | Sorting    |
      | Title   | ascending  |
      | Title   | descending |
      | Company | ascending  |
      | Company | descending |

  Scenario Outline: User cannot add a course if invalid <field> provided
    When User clicks on 'Add' 'button'
    And User is on 'Course Details Page' page
    And User clicks on 'Title' ' '
    And User enters 'Async Await in Js' in 'Title' field
    And User enters 'Kevin Mathews' in 'coordinator' field
    And User clicks on 'Name' ' '
    And User enters 'abcd' in "<field>" field
    And User clicks on 'save' 'button'
    Then '<Error>' message is displayed under '<field>' field

    Examples:
      | field    | Error                                  |
      | duration | Should be a valid time in HH:MM format |
      | cost     | Should be a valid number               |

  Scenario: User is able to delete a course
    When User selects 'a course'
    And User goes to 'delete option'
    And User clicks on 'delete selected' 'option'
    Then 'A modal dialog' is displayed
    When User clicks on 'yes, delete' 'button'
    Then 'Course' was deleted


#  Scenario Outline: User cannot add a course if at least the mandatory fields are not filled
#    When User clicks on 'Add' 'button'
#    And User is on 'Course Details Page' page
#    And User clicks on 'Title' ' '
#    And User enters "<Course title>" in 'title' field
#    And User enters "<Coordinator name>" in 'coordinator' field
##    And User clicks on 'Name' ' '
#    And User clicks on 'Save' 'button'
#    Then 'Required' message is displayed under '<field>' field
#
#    Examples:
#      | Course title      | Coordinator name | field
#      | Async Await in Js |                  | coordinator
#      |                   | Khloe Jayden     | title

  #  Scenario: User cannot add a course if invalid coordinator name provided
#    When User clicks on 'Add' 'button'
#    And User is on 'Course Details Page' page
#    And User clicks on 'Title' ' '
#    And User enters 'Async Await in Js' in 'Title' field
#    And User enters 'No such name' in 'coordinator' field
#    And User clicks on 'Save' 'button'
#    Then 'Invalid' message is displayed under 'coordinator' field
#
#  Scenario: User is able to edit a course
#    When User clicks on 'Docker Training course' 'link'
#    Then 'Course details page' is displayed
#    When User edits the title to 'Docker Training Extended'
#    And User edits Company as 'Endava'
#    And User clicks on 'save' 'button'
#    Then 'Course' was successfully updated
#

#  Scenario Outline: Pagination links are not displayed
#    Given <nrOfCourses> items in the system
#    And <rowsPerPage> courses options chosen
#      | rowsPerPage |
#      | 10          |
#    When User is on <currentPage> page
#    Then <target page link> is not displayed
#    Examples:
#      | nrOfCourses | currentPage | target page link |
#      | 10          | 1           | next page        |
#      | 10          | 1           | previous page    |
#      | 11          | 2           | next page        |
#
#  Scenario Outline: Pagination links are displayed and functional
#    Given <nrOfCourses> items in the system
#    And <rowsPerPage> courses options chosen
#      | rowsPerPage |
#      | 10          |
#    When User is on <currentPage> page
#    Then <target page link> is displayed
#    When User clicks on <target page link>
#    Then <target page link> is displayed
#    Examples:
#      | nrOfCourses | currentPage | target page link |
#      | 11          | 1           | next page        |
#      | 11          | 2           | previous page    |
#      | 21          | 2           | previous page    |
#      | 21          | 2           | next page        |
#      | 21          | 3           | previous page    |