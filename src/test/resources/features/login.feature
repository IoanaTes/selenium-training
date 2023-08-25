@test
Feature: Login feature

  Scenario Outline: Login
    Given the user accesses the website
    And the user introduces the "<credentials>"
    When the user clicks on Login button
    Then the user should be "<outcome>" logged in
    Examples:
      | credentials         | outcome          |
      | valid credentials   | successfully     |
      | invalid credentials | not successfully |



