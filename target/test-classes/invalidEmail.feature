Feature: user is creating an account

Scenario: User should insert invalid email
Given  Navigate to website
When We create an account
  | Field    | Value            |
  | Name     | firstname        |
  | Surname  | secondname       |
  | Phone    | 66677788         |
  | Email    | andris@andris.lv |
  | Male     | Male             |
  | Id       | 666666-55555     |
Then Registration failed
