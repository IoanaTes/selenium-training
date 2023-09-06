@test
Feature: Add employee

  Scenario: Adding a new employee successfully
    Given the user accesses the website
    And the user introduces the "valid credentials"
    And the user presses on Login button
    And the user clicks on PIM link from the menu
    And the user chooses the Add Employee option
    And the user adds a profile picture for that employee
    And the user enters the employee's full name in the Employee Full Name section
    And the user introduces an employee id in the Employee Id field
    And the user clicks the Create Login Details button to make the option available
    And the user adds a username and password
    And the user presses the Save button for employee
    Then the user should see a confirmation message that the employee was successfully saved