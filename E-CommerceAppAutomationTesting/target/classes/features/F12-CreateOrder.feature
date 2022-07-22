Feature: SC12- Create successful Order
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    And user navigate to books pages
    And user add items to shopping cart
    And user navigate to shopping cart
    And user complete order

  @scenario12
  Scenario: SC12- Create successful Order
    Then order placed successfully
