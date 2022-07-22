Feature: SC6- Logged user could select different Categories
  Background:
    Given user navigate to home page
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button

  @scenario6
  Scenario: SC6- Logged user could select different Categories
    And user hover on electronic category
    And user click on cellPhone category
    Then cell phones page should appear to the user