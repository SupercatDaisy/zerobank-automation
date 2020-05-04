Feature: Account activity verification
  I want to verify these requirements

  Background:
    Given User is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Pay Bills" page


  Scenario: Title verification
    Then user verifies that title is "Zero - Pay Bills"

  Scenario: Verify submit message
    When user enters following Data:
      | Payee | Account | Amount | Date       | Description |
      | Apple | Loan    | 100    | 2020-05-05 | Anniversary |
    And user click on Pay button
    Then user verifies "The payment was successfully submitted." message displayed


  Scenario: Verify Alert message
    When user enters following missing Data:
      | Payee | Account | Amount | Date | Description |
      | Apple | Loan    |        |      | Anniversary |
    And user click on Pay button
    Then user verifies "Please fill out this field." alert displayed

  Scenario: Amount and Date field Validation check
    When  user enters following Data:
      | Payee | Account | Amount | Date | Description |
      | Apple | Loan    | *     | test | Anniversary |
    Then user should verify that Amount and Date fields are incorrect.