Feature: Search Map Functionality

  Background:
    Given I am on the login page
    When I login with valid credentials from config
    Then I should be logged in successfully

  @searchMap
  Scenario Outline: Search for a valid city map
    When I enter city "<city>"
    Then the search button should be enabled
    When I click the search button
    Then I should see the city map

    Examples:
      | city      |
      | Santiago  |
      | Bogota    |
      | Lima      |

  @searchMap
  Scenario: Search button disabled when empty
    Given I enter city ""
    Then the search button should be disabled
