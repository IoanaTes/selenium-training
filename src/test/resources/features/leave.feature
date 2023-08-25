Feature: Leave link

  Scenario: Rejected status added successfully
    Given the user accesses the website
    And the user introduces the "valid credentials"
    And the user clicks on Login button
    When user clicks the Leave link from the menu
    And user selects the Rejected status from the 'Show Leave with Status' section
    Then user checks that the Rejected status is present as a selection
