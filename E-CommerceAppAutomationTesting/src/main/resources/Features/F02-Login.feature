Feature: SC2- User could log in with valid email and password
  Background:
    Given user navigate to home page

  @scenario2
  Scenario: SC2- User could log in with valid email and password
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    Then user should have a success message for login
