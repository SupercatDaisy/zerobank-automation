Feature: Account activity verification
  I want to verify these requirements

  Background:
    Given User is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Account Activity" page


  Scenario: Title verification
    Then user verifies that title is "Zero - Account Activity"


  Scenario: Account dropdown default  value
    Then user verifies account dropdown has "Savings" default option


  Scenario: Account dropdown menu options;
    Then user verifies account dropdown has following options :
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transaction table verification
    Then user verfies Transaction table have following column names:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |