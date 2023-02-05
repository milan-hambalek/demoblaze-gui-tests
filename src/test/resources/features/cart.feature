@Cart
Feature: Cart

Background:
    Given Unsigned user is at "https://www.demoblaze.com" site

  Scenario: Unsigned user adds 3 randomly chosen products into cart
    When User opens detail page of 1st product
    And Adds it into cart
    And Goes back to main page
    When User opens detail page of 2nd product
    And Adds it into cart
    And Goes back to main page
    When User opens detail page of 3rd product
    And Adds it into cart
    And Opens up cart page
    Then User should see all selected products in cart
    And Total price is equal to sum of product prices
