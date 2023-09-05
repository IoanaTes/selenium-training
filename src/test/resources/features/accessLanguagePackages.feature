@test
Feature: Access the language packages

  Scenario: Access the language package successfully
Given the user accesses the website
When the user introduces the "valid credentials"
And the user presses on Login button
And the user navigates to the 'Admin' link from the menu
And the user clicks on the 'Configuration' dropdown menu button
And the user selects the 'Language Packages' option
And the user clicks on the 'Translate' button for "Spanish - Español" language package
Then the user should be redirected to the Language Customization page