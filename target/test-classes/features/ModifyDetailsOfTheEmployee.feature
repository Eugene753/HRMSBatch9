Feature: Modify Employee

  @modifyemployee
  Scenario: Select employee from employee list and modify personal details
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enter employee first name "Ievgenii"
    And click on search button
    And user click on employee name from the employee list "Ievgenii"
    When user click on edit button
    And user change first name to "Eugene"
    And user enters license expiration date
    Then user click on save button
    Then user verifies that employee name was changed


