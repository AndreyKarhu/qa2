Feature: Create account with emppty fields

  Scenario: User should not be able to create an account without adding any data
    Given  Navigate to website
    When We create an account
      | Field    | Value |
      | fullname |       |
      | surname  |ewewe  |
      | phone    | ewew  |
      | email    | qwfds |
      | Male     | Male  |
      | id       |sdfsdf |
    Then registration error should be shown


  Scenario: User should not be able to create an account without adding any data
    Given  Navigate to website
    When We create an account
      | Field    | Value |
      | fullname | ewew  |
      | surname  |       |
      | phone    | ewew  |
      | email    | qwfds |
      | Male     | Male  |
      | id       |       |
    Then registration error should be shown


  Scenario: User should not be able to create an account without adding any data
    Given  Navigate to website
    When We create an account
      | Field    | Value |
      | fullname | ewew  |
      | surname  | ewewe |
      | phone    |       |
      | email    | qwfds |
      | Male     | Male  |
      | id       |       |
    Then registration error should be shown



  Scenario: User should not be able to create an account without adding any data
    Given  Navigate to website
    When We create an account
      | Field    | Value |
      | fullname | ewew  |
      | surname  |ewewe  |
      | phone    | ewew  |
      | email    |       |
      | Male     | Male  |
      | id       |       |
    Then registration error should be shown



  Scenario: User should not be able to create an account without adding any data
    Given  Navigate to website
    When We create an account
      | Field    | Value |
      | fullname | ewew  |
      | surname  |ewewe  |
      | phone    | ewew  |
      | email    | qwfds |
      | Male     | Male  |
      | id       |       |
    Then registration error should be shown