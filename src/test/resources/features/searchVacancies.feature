@test
Feature: Search for vacancies
  Scenario:  Search for Automation Tester vacancies successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user clicks on Recruitment link from the menu which will redirect me to the viewCandidates page
    And the user clicks on the Vacancies option
    And the user searches for vacancies with job title as Account Assistant
    Then the user can see that all records are displayed for Account Assistant