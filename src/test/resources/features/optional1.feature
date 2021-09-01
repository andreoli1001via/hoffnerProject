# language: en

  @HoffnerScenario03
  Feature: Hoffner page email subscription
  Scenario Outline: Subscription is in progress with wrong email
    Given a Hoffner login page
    When I open a page
    And I accept the cookie popup
    Then I can see a newsletter subscription input

    When I enter my "<wrongEmail>" in the input field
    And I press Absenden button
    Then I can see an email error message

    Examples:
      | wrongEmail         |
      | testtest.com       |


