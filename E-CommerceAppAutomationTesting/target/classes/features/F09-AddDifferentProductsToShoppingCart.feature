Feature: SC9- Logged user could add different products to Shopping cart
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    And user navigate to books pages

  @scenario9
  Scenario: SC9- Logged user could add different products to Shopping cart
    And user add items to shopping cart
    And user navigate to shopping cart
    Then added items should appear at shopping cart
