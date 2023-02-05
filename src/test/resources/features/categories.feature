@Categories
Feature: Product categories

Background:
    Given Unsigned user is at "https://www.demoblaze.com" site

  Scenario: Browse all sorts of products
    When User browses through products without specifying category
    Then User should see all available products in correct order

  Scenario: Browse phones
    When User chooses "Phones" category and browses phones
    Then User should see all available phones in correct order

  Scenario: Browse laptops
    When User chooses "Laptops" category and browses laptops
    Then User should see all available laptops in correct order

  Scenario: Browse monitors
    When User chooses "Monitors" category and browses monitors
    Then User should see all available monitors in correct order