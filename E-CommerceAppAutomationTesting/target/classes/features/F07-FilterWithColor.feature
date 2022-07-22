Feature: SC7- Logged user could filter with color
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button

  @scenario7
  Scenario: SC7- Logged user could filter with red color
    And user hover on apparel category
    And user click on shoes category
    And user change color to red
    Then shoes with red color only should appear to the user
