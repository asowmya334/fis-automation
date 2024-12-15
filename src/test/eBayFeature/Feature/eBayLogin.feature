Feature: Verify the item added to the cart

  Scenario: Verify Item is added to the cart on ebay
    Given I am on ebay login page and key in user credentials
    When search the item given below
      |Books|
    And I select first item from the list and add to cart
    Then Verify the cart is updated and displays the number of items in the cart 1
