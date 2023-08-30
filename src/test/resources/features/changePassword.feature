@test
Feature: Password change

  Scenario: Change the current password successfully
    Given the user accesses the website
    And the user introduces the "valid credentials"
    And the user presses on Login button
    When the user selects the 'Change Password' option from drop-down user profile menu
    And the user enters the current password in the 'Current Password' field
    And the user enters in the 'Password field' a new password
    And the user confirms the new password
    And the user presses the Save button to update the password
    Then the user should be able to see the confirmation message
