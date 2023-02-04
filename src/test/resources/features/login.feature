@Login
Feature: Log in

Background:
    Given User is at "https://www.demoblaze.com" site
    And Opens up "Log In" form

    @InvalidCredentials
    Scenario Outline: Log in with incomplete credentials
      When User logs in with username as "<username>" and password as "<password>"
      Then User should see alert message "Please fill out Username and Password."

    Examples:
      | username   | password  |
      |            | pw215483  |
      | user       |           |
      |            |           |

#  @ValidCredentials
#  Scenario: Sign up with valid credentials
#    When User submits unique username and password
#    Then User should see alert message "Sign up successful."