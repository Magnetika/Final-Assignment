Feature: Shopping Cart functionality
  Scenario: Add item to cart
    Given the user is on a product page
    When the user adds the item to the cart
    Then the cart counter should show 1

  Scenario: Add same item twice
    Given the user is on a product page
    When the user adds the same item twice
    Then the cart counter should show 2

  Scenario: Add two different items
    Given the user is on two different product pages
    When the user adds both items to the cart
    Then the cart counter should show 2

  Scenario: Remove an item from the cart
    Given the user has items in the cart
    When the user removes an item
    Then the item should be removed

  Scenario: Empty the cart
    Given the user has items in the cart
    When the user empties the cart
    Then the cart counter should show 0

