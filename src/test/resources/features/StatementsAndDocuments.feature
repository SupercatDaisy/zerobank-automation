Feature: Statements and Documents details



  Scenario Outline: Recent statements per year
    Given User is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Online Statements" page
    When the user selects the Recent Statements Year <year>
    Then <count> statements should be displayed for that year
    Examples:
      | year | count |
      | 2009 | 2     |
      | 2010 | 2     |
      | 2011 | 2     |
      | 2012 | 1     |


  @download
  Scenario Outline: Download statements
    Given user is on landing page
    When User click on Signin button
    And User logs in with valid credentials
    When user navigates to "Online Statements" page
    And the user selects the Recent Statements Year <year>
    When the user clicks on statement "<statement>"
    Then the downloaded file name should contain "<name>"
    And the file "<name>" type should be pdf
    Examples:
      | year | statement               | name     |
      | 2009 | Statement 31/11/09(57K) | 31-11-09 |
      | 2010 | Statement 01/12/10(57K) | 01-12-10 |
      | 2011 | Statement 05/12/11(57K) | 05-12-11 |
      | 2012 | Statement 01/10/12(57K) | 01-10-12 |

      #For those who will read my code and implementation to get some idea;
      #@download tag Given Step is unique, It directs to pre-configured chrome driver by me.
      #You can check it under my Driver class "chromeDownload"
      #Some of the steps requires Java and library knowledge
      #You can reach out to me at "ilhancicd@gmail.com"
      #I wrote this just for this homework but I can provide more dynamic solution
      #More dynamic solution consist of other browsers and regardless of fileName
      #Happy coding ladies and gentleman