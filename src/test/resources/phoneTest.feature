Feature: user is creating an account

Scenario: User phone should not be less then 5 digits
  Given  Navigate to website
  When We create an account
  | Field    | Value            |
  | Name     | firstname        |
  | Surname  | secondname       |
  | Phone    | 66               |
  | Email    | andris@andris    |
  | Male     | Male             |
  | Id       | 666666-55555     |
Then User is registered with short number


  Scenario: User phone can contains +;/;letters; more than 11 digits
    Given  Navigate to website
    When We create an account
      | Field    | Value                  |
      | Name     | firstname              |
      | Surname  | secondname             |
      | Phone    | +32131/42343242342423  |
      | Email    | andris@andris          |
      | Male     | Male                   |
      | Id       | 666666-55555           |
    Then User is registered with short number