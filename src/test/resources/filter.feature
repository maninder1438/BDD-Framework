@filter
Feature: Filter
  As an end user
  I want to apply filters
  So that i can find desired product

  @smoke
  Scenario: Verify product rating filter
    Given I am on homepage
    When I search for a product of "Apple MacBook Air 2019"
    And Select the product rating "4or more" from the rating filter
    Then I should be able to see the products of rating "4.0"

  @smoke
  Scenario: Verify product price filter
    Given I am on homepage
    When I search for a product of "phone sim free"
    And  Select the price "£150 - £200" from price filter
    Then I should be able to see the products having price between "£150 - £200"