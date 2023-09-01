@test
Feature: Add a new job

  Scenario: Add a new job successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user navigates to the 'Admin' link from the menu
    And the user selects the Job Titles option from the Job menu dropdown
    And the user clicks the Add button to add a new job
    And the user adds a name for the job in the Job Title field
    And the user adds a job description
    And the user adds a Job Specification file
    And the user clicks the 'Save' button to add the new job
    Then the user should see the confirmation message that the job was successfully added