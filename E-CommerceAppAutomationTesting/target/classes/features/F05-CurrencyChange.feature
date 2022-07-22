Feature: SC5- Logged User could switch between currencies US-Euro
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button

  @scenario5
  Scenario: SC5- Logged User could switch between currencies US-Euro
    And user change currency from usd to euro
    Then all products shown are in euro
