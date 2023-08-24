@test
Feature: Login feature

  Scenario: Successful login
    Given I access the website
    And I use the "Admin" username and "admin123" password
    When I click on Sign In button
    Then I should be logged in successfully



