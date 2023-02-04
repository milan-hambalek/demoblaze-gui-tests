@Signup
Feature: Sign up new user

Background:
    Given Unsigned user is at "https://www.demoblaze.com" site
    And Opens up "Sign Up" form

    @InvalidCredentials
    Scenario: Sign up with already existing username
      When User signs up with username as "user" and unique password
      Then User should see alert message "This user already exist."

    @InvalidCredentials
    Scenario Outline: Sign up with incomplete credentials
      When User signs up with username as "<username>" and password as "<password>"
      Then User should see alert message "Please fill out Username and Password."

    Examples:
      | username   | password  |
      |            | pw215483  |
      | user548793 |           |
      |            |           |

  @ValidCredentials
  Scenario: Sign up with valid credentials
    When User signs up with unique username and password
    Then User should see alert message "Sign up successful."