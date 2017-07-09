Feature: user is creating an account

  Scenario: Test scores

    Given  Open the registration page
    When We create new account
      | Field    | Value            |
      | Name     | firstnametest    |
      | Surname  | secondname       |
      | Phone    | 66677788         |
      | Email    | andris           |
      | Male     | Male             |
      | Id       | 666666-55555     |


    Then Press Add score
    Then Filling the form
      | Field             | Value         |
      | Age               | 24            |
      | City              | Riga          |
      | Country           | Latvia        |
      | Children count    | 2             |


    Then Check if score is correct
      | Field             | Value         |
      | Age               | 24            |
      | City              | true          |
      | Country           | true          |
      | Children count    | 2             |


#City- write true if Riga, other way false
#Country- write true if Latvia, other way false