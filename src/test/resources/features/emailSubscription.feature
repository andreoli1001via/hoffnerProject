# language: en

@HoffnerScenario01
Feature: Hoffner page email subscription

  Scenario Outline: Subscription is in progress
    Given a Hoffner login page
    When I open a page
    And I accept the cookie popup
    Then I can see a newsletter subscription input

    When I enter my "<email>" in the input field
    And I press Absenden button
    Then I can see a confirmation message that my subscription is in progress

    Examples:
      | email         |
      | test@test.com |


