@search
Feature: Search
  As an end user
  I want to search for product
  So that i can view product i wish

  @smoke
  Scenario: Search for single product
    Given I am on homepage
    When I search for a product of "jbjkbkbkjhkbbhbhbjhk5454"
    Then I should be able to see "nijhbvjhbvhjjhjh5454ke" product

  @regression
  Scenario Outline: Search multi product
    Given I am on homepage
    When I search for a product of "<searchItem>"
    Then I should be able to see "<searchItem>" product

    Examples:
      | searchItem |
      | puma       |
      | adidas     |


