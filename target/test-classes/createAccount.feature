Feature: user is creating an account


  Scenario: User should be able to create an account
    Given  Navigate to website
    When We create an account
      | Field    | Value            |
      | Name     | firstnametest    |
      | Surname  | secondname       |
      | Phone    | 66677788         |
      | Email    | andris           |
      | Male     | Male             |
      | Id       | 666666-55555     |
    Then Should navigate on main page



  Scenario: User should be able to create an account with incorrect personalId
    Given  Navigate to website
    When We create an account
      | Field    | Value            |
      | Name     | firstnametest    |
      | Surname  | secondname       |
      | Phone    | 66677788         |
      | Email    | andris           |
      | Male     | Male             |
      | Id       | wqeeweqwqweq     |
    Then Should navigate on main page


  Scenario: User should be able to create an account with 64 digits
    Given  Navigate to website
    When We create an account
      | Field    | Value                                                                              |
      | Name     | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa   |
      | Surname  | bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb   |
      | Phone    | 66677788                                                                           |
      | Email    | andris                                                                             |
      | Male     | Male                                                                               |
      | Id       | wqeeweqwqweq                                                                       |
    Then Should navigate on main page