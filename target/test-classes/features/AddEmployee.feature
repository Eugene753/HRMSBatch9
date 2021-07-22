Feature: Adding employees
  Background:
    And user is logged in with valid admin credentials
    When user click on PIM option
    And user click on Add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user click on save button option
    Then employee added successfully

  @smoke
    Scenario:Adding employee from add employee page via feature file
      And user enters first name "Yulia123" middle name "MS" and lastname "Yulia456"
      And user click on save button option
      Then employee added successfully

  @example
    Scenario Outline: Adding employee from add employee page via feature file
      And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
      And user click on save button option
      Then employee added successfully

    Examples:

    |FirstName|MiddleName|LastName|
    |Test12347|MS        |Test9879|
    |Test12125|MS        |Test7655|
    |Test32320|MS        |Test5451|

    @datatablewithheader
    Scenario: Adding multiple employees in a single execution
      When add multiple employees and verify they are added successfully
      |FirstName|MiddleName|LastName|
      |John0404 |MS        |US      |
      |Jack     |MS        |US      |
      |MS0909   |MS        |US      |

    @excel
    Scenario: Adding employee from excel file
      When user adds multiple employees from excel file from "testdata" sheet and verify they are added

    @db
    Scenario: Add the employee and testing it from the backend
      When user enters first name "Yulia123" middle name "MS" and lastname "Yulia456"
      And capture the employeeId
      And user click on save button option
      Then query the HRMS database
      And verify the data from frontend and backend
