Feature: The Internet Checkboxes Page

  @CHECKBOXES
  Scenario Outline: Verify checkbox selection functionality
    Given I am on the Checkboxes page
    When I select checkbox <num>
    Then The checkbox <num> should be checked

    Examples:
      | num |
      | 1   |
      | 2   |

    #*** Previously Scenario Name : "I can log into the secure area" doesn't match checkbox testing"***