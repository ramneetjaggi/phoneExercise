Feature: Update User information

  Scenario: Update user preferred phone
    Given User exists in the system
    When User adds a preferred phone number
    Then User preferred number is updated