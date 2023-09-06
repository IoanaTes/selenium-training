@test
Feature: Add a comment for Leave records

  Scenario: Add a comment for Leave records successfully
    Given the user accesses the website
    And the user introduces the "valid credentials"
    And the user presses on Login button
    When user clicks the Leave link from the menu
    And the user clicks on the button with three dots which is located in the left corner for an employee record
    And the user selects to Add Comment from that list
    And the user enters a comment in the Leave Request Comments section
    And the user saves the comment
    Then the user should be able to see the confirmation message that the comment was added successfully
    And the user should also be able to see the comment after refreshing the page
