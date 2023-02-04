@Login
Feature: Log in

#  test user: lilyshen / password_xc2

Background:
    Given Unsigned user is at "https://www.demoblaze.com" site
    And Opens up "Log In" form

    @InvalidCredentials
    Scenario Outline: Log in with wrong credentials
      When User logs in with username as "<username>" and password as "<password>"
      Then User should see alert message "<message>"

    Examples:
      | username   | password      | message              |
      | lilyshen   | wrong_pw      | Wrong password.      |
      | lily3568   | password_xc2  | User does not exist. |

    @InvalidCredentials
    Scenario Outline: Log in with incomplete credentials
      When User logs in with username as "<username>" and password as "<password>"
      Then User should see alert message "Please fill out Username and Password."

    Examples:
      | username   | password     |
      |            | password_xc2 |
      | lilyshen   |              |
      |            |              |

    @ValidCredentials
    Scenario: Log in with valid credentials
      When User logs in with username as "lilyshen" and password as "password_xc2"
      Then User "lilyshen" should log in successfully