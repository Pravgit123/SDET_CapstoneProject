Feature: Verification

  Scenario: Successful login
    Given User is on the login page
    When User enters valid credentials
    And User clicks on the login button
    Then User should be logged in successfully

  Scenario: Unsuccessful login
    Given User is on the login page
    When User enters invalid credentials
    And User clicks on the login button
    Then User should see an error message
