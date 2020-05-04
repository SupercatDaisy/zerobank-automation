Feature: Purchase Foreign Currency

  Background:
    Given User is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Pay Bills" page
    Then user select "Purchase Foreign Currency" tab



  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed