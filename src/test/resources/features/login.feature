@test
Feature: Login feature

  Scenario Outline: Login
    Given user access the website
    And user uses the "<username>" username and correct password
    When user clicks on Sign In button
    Then user should "<outcome>"
    Examples:
      | username  | outcome                 |
      | Gusername | log in successfully     |
      | Busername | NOT log in successfully |



