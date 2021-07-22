Feature: Dashboard tab functionality



  @dashboardtabs
  Scenario: Dashboard tab verification
    When user enters valid admin username and password
    And user click on login button
    Then admin user is successfully logged in
    Then verify the following tabs on dashboard
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|