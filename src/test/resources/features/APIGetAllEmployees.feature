Feature: Get data from all employees
  Background:
    Given  JWT is generated
  @APIRetrievingAllEmployees
  Scenario: Get data from all employees
    Given request is prepared to retrieve all employees from database
    When a GET call is made to retrieve all employees
    Then verify a status code for retrieving all employees is 200
    And count how many employees we have in Database
    And retrieve "employee_id", "emp_firstname", "emp_middle_name", "emp_lastname"