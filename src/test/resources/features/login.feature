@test
Feature: Login feature

  Scenario: Successful login
    Given I access the website
    And I use the correct credentials
    When I click on Sign In button
    Then I should be logged in successfully



