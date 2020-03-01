@filter
Feature: Filter
  As an end user
  I want to apply filters
  So that i can find desired product

  @smoke @ratingfilter
  Scenario: Verify product rating filter
    Given I am on homepage
    When I search for a product of "Apple MacBook Air 2019"
    And Select the product rating "3or more" from the rating filter
    Then I should be able to see the products of rating "3.0"

  @smoke @pricefilter
  Scenario: Verify product price filter
    Given I am on homepage
    When I search for a product of "laptop"
    And  Select the price "£1000 - £2000" from price filter
    Then I should be able to see the products having price between "£1000 - £2000"

  @smoke @brandfilter
  Scenario: Verify product brand filter
    Given I am on homepage
    When I search for a product of "phone cover"
    And  Select the brand name "apple" from the brands filter
    And  Select the random product from product list
    Then Verify that selected product has brand name"Apple"

  @smoke @rating&pricefilter
  Scenario: Verify product rating filter & price filter
    Given I am on homepage
    When I search for a product of "laptop"
    And Select the product rating "5only" from the rating filter
    And Select the price "£1000 - £2000" from price filter
    Then I should be able to see the products of rating "5.0"
    And I should be able to see the products having price between "£1000 - £2000"


