Feature: SC8- Logged user could select different tags
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button

  @scenario8
  Scenario: SC8- Logged user could select awesome tag
    And user open search page
    And user choose awesome tag
    Then awesome products page should appear to the user
