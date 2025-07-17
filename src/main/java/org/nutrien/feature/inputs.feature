@INPUTS
Feature: The Internet Inputs Page

  Scenario Outline: Verify number input functionality
    Given I am on the inputs page
    When I enter "<num>"
    Then The input value should be the number I entered

    Examples:
      | num |
      | 0   |
      | 1   |
      | 2   |
      | 3   |
      | 4   |