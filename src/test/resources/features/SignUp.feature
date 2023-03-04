Feature: Sign Up on Digital Bank

  @Smoke
  Scenario: Sign up a new account on Digital Bank
    Given user clicks on Sign Up Here link
    When user enters information in all fields
    And user clicks Next button
    When user enters information in all fields on next page
    And user clicks Register button
    Then user sees Success message on Sign In page