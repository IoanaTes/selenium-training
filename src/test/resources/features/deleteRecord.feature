Feature: Delete record from Contact details

  Scenario: Adding an attachment to contact details successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'My Info' page from the menu
    And the user clicks on the 'Contact Details' link which will redirect to the 'Contact Details' page
    And the user ticks the checkbox to select one record saved in the Records Found section
    And the user presses the 'Delete' button to delete that record
    And the user selects 'Yes' to confirm the deletion
    Then the user should receive a confirmation message that the record has been deleted successfully
