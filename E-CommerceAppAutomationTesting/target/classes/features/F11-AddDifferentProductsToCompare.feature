Feature: SC11- Logged user could add different products to compare list
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    And user navigate to books pages

  @scenario11
  Scenario: SC11- Logged user could add different products to compare list
    And user add items to compare list
    And user navigate to compare list
    Then added items should appear at compare list
