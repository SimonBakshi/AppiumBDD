Feature: Product Scenarios

  Scenario Outline: Validate product info on Products page
    Given I am logged in
    Then The product is listed with title "<title>" and price "<price>"
    Examples:
      | title                   | price  |
      | Sauce Labs Bolt T-Shirt | $15.99 |


  Scenario Outline: Validate product info on Product details page
    Given I am logged in
    When I click product title "<title>"
    Then I should be on product details page with title "<price>", price "<price>" and description "<description>"
    Examples:
      | title               | price  | description |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly|
