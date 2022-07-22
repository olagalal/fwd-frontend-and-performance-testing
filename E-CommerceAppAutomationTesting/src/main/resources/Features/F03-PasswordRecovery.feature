Feature: SC3- User could reset his/her password successfully
  Background:
    Given user navigate to home page
    And user clicked on login link

  @scenario3
  Scenario: SC3- User could reset his/her password successfully
    And user clicked on forgot password
    And user entered email for reset password
    And user clicked on recover button
    Then user should have a success message for recover
