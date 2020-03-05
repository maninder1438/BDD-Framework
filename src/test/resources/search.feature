@search
Feature: Search
  As an end user
  I want to search for product
  So that i can view product i wish

  @smoke
  Scenario: Search for single product
    Given I am on homepage
    When I search for a product of "nike"
    Then I should be able to see "nike" product

  @regression
  Scenario Outline: Search multi product
    Given I am on homepage
    When I search for a product of "<searchItem>"
    Then I should be able to see "<searchItem>" product

   Examples:
      |     searchItem  |
      |      puma       |
      |     adidas      |
      |    smart watch  |



