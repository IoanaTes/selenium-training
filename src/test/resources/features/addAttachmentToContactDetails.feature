@test
Feature: Add attachment to Contact Details

  Scenario: Adding an attachment to contact details successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'My Info' page from the menu
    And the user clicks on the 'Contact Details' link which will redirect to the 'Contact Details' page
    And the user clicks the 'Add Attachments' button
    And the user selects to upload a file
    And the user adds a comment for this document uploaded in the comment field
    And the user presses the Save button for this attachment added
    Then the user will be able to see the document added in the record found section