@Cart
Feature: Cart

Background:
    Given Unsigned user is at "https://www.demoblaze.com" site

  Scenario: User adds 3 randomly chosen products into cart
    When User opens detail page of 1st product
    And Adds it into cart
    And Goes back to main page
    When User opens detail page of 2nd product
    And Adds it into cart
    And Goes back to main page
    When User opens detail page of 3rd product
    And Adds it into cart
    And Goes to cart page
    Then User should see all selected products in cart
    And Total price is equal to sum of product prices

  Scenario: User clears the cart
    Given User adds 3 randomly chosen products into cart
    And Goes to cart page
    When User removes 1. item from cart
    Then Item should disappear from cart list
    And Total price should update accordingly
    When User removes 2. item from cart
    Then Item should disappear from cart list
    And Total price should update accordingly
    When User removes 3. item from cart
    Then Item should disappear from cart list
    And Total price should display no value

