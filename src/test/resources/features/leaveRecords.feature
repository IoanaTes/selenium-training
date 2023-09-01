@test
Feature: See vacation leave records

  Background:
    Given the user accesses the website
    And the user introduces the "valid credentials"
    And the user presses on Login button
    When user clicks the Leave link from the menu


  Scenario: Filter vacation leave records for a certain period successfully
    And the user selects a specific period for which I want to see the records
    And the user selects to see only leave with Pending Approval status
    And the user sets Leave Type as 'US - Vacation'
    And the user presses search button
    Then the user should see all the records with all the data entered


  Scenario: Filter personal leave records for a certain person and period successfully
    And the user selects '2022-08-01' to '2023-12-31' as a period for which I want to see the records
    And the user selects to see only leave with Pending Approval status
    And the user sets Leave Type as 'CAN - Personal'
    And the user enters Anthony Nolan in the Employee Name field
    And the user presses search button
    Then the user should see a pop-up message that says no records found
    And the user clicks on the Reset button