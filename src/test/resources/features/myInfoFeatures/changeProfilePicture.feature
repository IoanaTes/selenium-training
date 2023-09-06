@test
Feature: Change profile picture

  Scenario: Changing profile picture successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'My Info' page from the menu
    And the user clicks on the profile picture
    And the user adds a picture
    And the user clicks the 'Save' button
    Then the user can see that the profile picture has been updated