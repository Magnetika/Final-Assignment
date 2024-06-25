Feature: Search functionality
  Scenario: Common search term
    Given the user is on the homepage
    When the user enters a common search term
    Then the results should be displayed

  Scenario: Less common search term
    Given the user is on the homepage
    When the user enters a less common search term
    Then the results should be displayed

  Scenario: Multiple search terms
    Given the user is on the homepage
    When the user enters multiple search terms
    Then the results should be displayed

  Scenario: Unlikely search term
    Given the user is on the homepage
    When the user enters an unlikely search term
    Then no results should be displayed

  Scenario: No search term
    Given the user is on the homepage
    When the user enters a whitespace or no search term
    Then no results should be displayed

