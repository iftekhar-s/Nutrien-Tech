@DROPDOWN
Feature: The Internet Dropdown Page

  Scenario Outline: Verify dropdown selection functionality
    Given I am on the Dropdown page
    When I select "<option>"
    Then The dropdown value should be "<option>"

    Examples:
      | option   |
      | Option 1 |
      | Option 2 |

  Scenario: Verify dropdown default state
    Given I am on the Dropdown page
    Then The dropdown value should be "Please select an option"

    #***Previously The second scenario using Outline since it has no Examples***
