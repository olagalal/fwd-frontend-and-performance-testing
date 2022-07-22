Feature: SC10- Logged user could add different products to Wishlist
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    And user navigate to books pages

  @scenario10
  Scenario: SC10- Logged user could add different products to Wishlist
    And user add items to wish list
    And user navigate to wish list
    Then added items should appear at wish list
