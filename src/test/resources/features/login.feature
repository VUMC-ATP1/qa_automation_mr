Feature: Login feature for SauceDemo


  Scenario Outline: Success Login
    Given I have navigate to login page
    When I login with '<username>' and '<password>'
    Then I am successfully logged in
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario: Error login - no username
    Given I have navigate to login page
    When  I login with '' and 'secret_sauce'
    Then  I see login error message 'Epic sadface: Username is required'

