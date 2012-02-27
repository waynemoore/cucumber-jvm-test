Feature: Account Holder withdraws cash

  @afm
  Scenario: Balance is adjusted
    Given the account balance is 100
    And the card is valid
    And the machine contains 100
    When the Account Holder requests 20
    Then the ATM should dispense 20
    And the account balance should be 70
    And the card should be returned

  @afm @tba
  Scenario: Test that tag exclusions work
    Given this scenario is tagged as @tba
    Then it will never be called