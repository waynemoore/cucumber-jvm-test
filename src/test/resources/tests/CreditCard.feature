Feature: Account Holder withdraws cash

  @afm
  Scenario: exception occurs in api call
    Given the account balance is 100
    And the card is valid
    And the machine contains 100
    When the Account Holder requests 20
    Then the ATM should dispense 20
    And the account balance should be 70
    And the card should be returned