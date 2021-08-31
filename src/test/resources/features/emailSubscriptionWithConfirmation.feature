# language: en

@HoffnerScenario02
Feature: : Hoffner with email received confirmation
  Scenario: : Subscription is in progress
    Given I create a temporary email
    Given a Hoffner login page
    When I open a page
    And I accept the cookie popup
    Then I can see a newsletter subscription input

    When I enter my temporary email in the input field
    And I press Absenden button
    Then I receive an email asking to confirm my email

    When I open the email
    Then there is a link to finish registration process

    When I click on Jetzt Anmeldung abschließen
    Then I am redirected to page confirming subscription


