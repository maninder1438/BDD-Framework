@filter
Feature: Filter
  As an end user
  I want to apply filters
  So that i can find desired product

  @smoke
  Scenario: Verify product rating filter
    Given I am on homepage
    When I search for a product of "Apple MacBook Air 2019"
    And Select the product rating "3or more" from the rating filter
    Then I should be able to see the products of rating "3.0"

  @smoke
  Scenario: Verify product price filter
    Given I am on homepage
    When I search for a product of "laptop"
    And  Select the price "£2000 - £5000" from price filter
    Then I should be able to see the products having price between "£2000 - £50000"

  @smoke
  Scenario: Verify product brand filter
    Given I am on homepage
    When I search for a product of "laptop"
    And  Select the brand name "apple" from the brands filter
    Then I should be able to see "apple" brand products only