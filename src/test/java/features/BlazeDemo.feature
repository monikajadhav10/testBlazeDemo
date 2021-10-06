Feature: Scenarios to verify blazedemo flight booking website

  Scenario: verify customer can book flight successfully
    Given I successfully launch blazedemo "url"
    And I select departure city as "Paris"
    And I select destination city as "London"
    When I click "Find Flights" button
    When I click "Choose This Flight" button
    Then I fill "inputName" as "Test123"
    Then I fill "address" as "Test345"
    Then I fill "city" as "Chennai"
    Then I fill "creditCardNumber" as "546464"
    When I click "Purchase Flight" button
    And I verify confirmation message as "Thank you for your purchase today!"

  