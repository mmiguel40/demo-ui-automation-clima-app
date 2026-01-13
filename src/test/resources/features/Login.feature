Feature: Login Functionality

  Background:
    Given I am on the login page

  @validCredentials
  Scenario: Successful Login with Valid Credentials
    When I enter username "usuariodev"
    And I enter password "123"
    And I click the login button
    Then I should be logged in successfully

  @logout
  Scenario: Successful Logout
    Given I am on the login page
    When I login with valid credentials from config
    Then I should be logged in successfully
    When I click the logout button
    Then I should be redirected to the login page

  @invalidCredentials
  Scenario Outline: Failed Login with Invalid Credentials
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see an error message "Usuario o contraseña incorrectos"

    Examples:
      | username       | password       |
      | invalidUser    | 123            |
      | usuariodev     | invalidPass    |
      | invalidUser    | invalidPass    |
