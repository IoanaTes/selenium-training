Feature: Add new language packages

  Scenario: Add Colognian package successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'Admin' link from the menu
    And the user clicks on the 'Configuration' dropdown menu button
    And the user selects the 'Language Packages' option
    And the user clicks the 'Add' button to add a new language to the packages
    And the user selects the Colognian language from that list
    And the user presses the 'Save' to add this new language to my packages
    Then the user should be able to see the confirmation message that the language was successfully saved