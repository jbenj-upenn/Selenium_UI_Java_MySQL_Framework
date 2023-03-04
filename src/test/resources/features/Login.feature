#9b. Begin features after DriverUtilities
Feature: Login Feature

  @Screen
  Scenario: Verify user is able to login with valid credentials
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on Sign In button
    Then verify user is successfully logged in to their account

      #10a. Create step definition package to store our copied methods

  @Smoke
  Scenario: Verify user is unable to login with invalid credentials
    Given user enters invalid "invalid.username" and "invalid.password"
    When user clicks on Sign In button
    Then verify user is unable to login

  @Smoke
  Scenario Outline: Verify user is unable to login with invalid credentials (scenario outline)
    Given user enters invalid username "<username>" and or invalid password "<password>"
    When user clicks on Sign In button
    Then verify user is unable to login
    Examples:
      | username                   | password        |
      | jayone@example.com         | TestPass1234    |
      | Test1@gmail.com            | PestPass1234    |
      | test1@email.com            | TestPass1234    |
      | joshuasevendavid@gmail.com | 340WChestnutSt! |

  @Smoke
  Scenario: Verify Remember Me option is selected when logging in
    Given user enters valid "valid.username" and "valid.password"
    When user selects Remember Me button
    And user clicks on Sign In button
    When verify user is successfully logged in to their account
    And user clicks back button
    Then verify username appears in user name field