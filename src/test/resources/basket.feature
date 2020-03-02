@basket
Feature: Basket
  As an end user
  I want to verify the basket product
  So that i can purchase the right selected product
  @smoke
  Scenario: Verify the product name in the basket
    Given I am on homepage
    When I search for a product of "tripods, monopods and cases"
    And Select the random product from product list
    And Add the selected product to basket
    Then I should be able to see the same selected product in the basket
  @smoke
  Scenario: Verify the price updated accurately for a single product but multiple quantity in the basket
    Given I am on homepage
    When I search for a product of "dash cam"
    And Select the random product from product list
    And change the quantity to "4"
    And Add the selected product to basket
    Then I should be able to see the correct price in the basket

  @regression
  Scenario: Verify the price & quantity in the basket when buying multiple products
    Given I am on homepage
    When I search for a product of "ipad pro"
    And Select the random product from product list
    And add the selected product to basket and click continue shopping
    And I search for a product of "hard drive"
    And Select the random product from product list
    And add the selected product to basket and click goto trolley
    Then I should be able to see "2" products in total in the basket
    And The price should be equal to the total of products in the basket

  @regression
  Scenario: Verify that I can reserve products
    Given I am on homepage
    When  I search for a product of "phone cover"
    And  Select the random product from product list
    And  change the quantity to "2"
    And  Add the selected product to basket
    And  Reserve the item to collect from store
    Then I should be able to see the reservation confirmation
    And  The selected quantity should be "2" on reservation confirmation
    And  The total price should be correct

  @regression @multipleFilter
  Scenario: Verify that I can reserve products using multiple filters
    Given I am on homepage
    When  I search for a product of "phone cover"
    And  Select the brand name "Apple" from the brands filter
    And Select the product rating "3or more" from the rating filter
    And  Select the price "£25 - £50" from price filter
    And  Select the random product from product list
    And  Verify that selected product has brand name"Apple"
    And  Verify that selected product has rating"3.0" or more
    And  I should be able to see the products having price between "25 - £50"
    And  change the quantity to "2"
    And  Add the selected product to basket
    And  Reserve the item to collect from store
    Then I should be able to see the reservation confirmation
    And  The selected quantity should be "2" on reservation confirmation
    And  The total price should be correct
