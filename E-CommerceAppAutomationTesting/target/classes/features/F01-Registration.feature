Feature: SC1- User could register with valid data
  Background:
    Given user navigate to home page
    And user clicked on register link

  @scenario1
  Scenario: SC1- User could register with valid data
    When user selected gender
    And user entered first name
    And user entered last name
    And user selected birth of date
    And user entered email for registration
    And user entered company name
    And user entered password for registration
    And user confirmed password for registration
    And user clicked on register button
    Then user should have a success message for registration
