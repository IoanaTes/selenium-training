@test
Feature: Street and country details update

  Scenario: Update the street and country details successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'My Info' page from the menu
    And the user clicks on the 'Contact Details' link which will redirect to the 'Contact Details' page
    And the user updates the Street 1 field from contact details
    And the user selects Algeria as country
    And the user presses the Save button
    Then the user should see the successfully updated confirmation message