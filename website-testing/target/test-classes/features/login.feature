Feature: Login functionality
  Scenario: Correct credentials
    Given the user is on the login page
    When the user enters correct username and password
    Then the user should be logged in

  Scenario: Missing username
    Given the user is on the login page
    When the user leaves the username field empty
    And the user enters the password
    Then the correct error message should be displayed

  Scenario: Missing password
    Given the user is on the login page
    When the user enters the username
    And the user leaves the password field empty
    Then the correct error message should be displayed

  Scenario: Incorrect credentials
    Given the user is on the login page
    When the user enters incorrect username or password
    Then the correct error message should be displayed

  Scenario: Logout
    Given the user is logged in
    When the user logs out
    Then the user should be logged out

