# language: en

  @HoffnerScenario04
  Feature: Hoffner page complete order
  Scenario Outline: Order completed to pay on deliver

    Given a Hoffner page
    When I open a page https://www.hoeffner.de/
    And I accept the cookie popup
    Then I can see the Search field
    When I enter my "<productName>" in the search field
    Then should be automatically displayed some similar goods on screen
    When I click on the product <"productName"> I want to buy
    Then I can see the product page
    When I put my address code
    And I click on In den Warenkorb button
    Then I can see a popup with Zum Warenkorb button
    When I click on Zum Warenkorb button
    Then I can see the Zur Kasse button
    When I click on Zur Kasse button
    Then I can see the Weiter als Gast button
    When I clck on Weiter als Gast button
    Then I can see the Ihre Rechnungsadresse fields
    When I fill all the fields and click on Weiter button
    Then I can see the Bitte wählen Sie eine Zahlart page
    When I click on Zahlung bei Lieferung (Nachnahme) and click on Weiter button
    Then I can see Bitte überprüfen und bestätigen Sie Ihre Bestellung page
    And press the Jetzt kaufen button

    Examples:
      | productName         |
      | bratpfanne          |


