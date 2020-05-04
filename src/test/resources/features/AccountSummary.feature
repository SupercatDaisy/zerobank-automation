Feature:  Account Summary
  I want to verify these requirements

  Background:
    Given User is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Account Summary" page


  Scenario: Account summary page verification
    Then user verifies that title is "Zero - Account Summary"

  Scenario: Account type verification
    Then user verifies that page has following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit account verification
    Then user verifies following credit account columns:
      | Account     |
      | Credit Card |
      | Balance     |