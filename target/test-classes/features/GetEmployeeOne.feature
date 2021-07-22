Feature: Getting one employee

  Background:
    Given  JWT is generated

  @oneemployee
  Scenario: Getting one employee
    Given request is prepared to retrieve employee "employee_id" is "23246A"
    When a Get call made to retrieve employee
    Then print get employee