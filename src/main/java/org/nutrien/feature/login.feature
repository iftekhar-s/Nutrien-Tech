@LOGIN
Feature: The Internet Login Page

  Scenario Outline: Verify login functionality //String type data was provided without "" in When & Then action
    Given I am on the login page
    When I login with "<username>" and "<password>"
    Then I should see a flash message saying "<message>"

    Examples:
      | username | password             | message                        |
      | tomsmith | SuperSecretPassword! | You logged into a secure area! |
      | foobar   | barfoo               | Your username is invalid!      |