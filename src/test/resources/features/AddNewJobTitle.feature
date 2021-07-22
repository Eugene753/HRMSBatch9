Feature: Add New Job Title

  @jobtitle
  Scenario: Adding new job title as Admin
    When user is logged in with valid admin credentials
    Then user click on Admin button
    Then user click on Job title button
    And user click on Add button
    When user add job title, job description, note
    Then user clicks on save button
    Then enter query into HRMS database
    And checks if information added from front end and back end
