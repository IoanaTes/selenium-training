@test
Feature: Access employee records

  Scenario: Access Anthony Nolan's record successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user clicks on Recruitment link from the menu which will redirect me to the purgeEmployee page
    And the user enters the admin password to validate my administrator credentials
    And the user clicks the Confirm button
    And the user clicks on the Access Records option
    And the user enters an employee in the Employee Name input field
    And the user clicks on the Search button
    Then the user can see that the employee ID is displayed in the Selected Employee section
