Feature: Login
  As a user, I want to be able to login with correct credentials.


  Background:
    Given User is on landing page
    When User click on Signin button

  @happy
  Scenario: Happy path login
    Given User logs in with valid credentials
    Then User should be able to see "Account Summary" page displayed

  @negative
  Scenario Outline: Log in with invalid credentials
    Given User logs in with incorrect "<username>" and "<password>"
    Then Error message "Login	and/or password are wrong." should be displayed
    Examples:
      |username|password|
      |invalid |invalid |
      |        |        |


