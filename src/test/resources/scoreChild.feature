Feature: user is creating an account


Scenario: Test form shouldn't be registered
  Given  Open page
  When Fill score field
    | Field             | Value         |
    | Age               | 24            |
    | City              | Riga          |
    | Country           | Latvia        |
    | Children count    | n             |
Then Assert if possible create acc

  Scenario: Age could be less than 18 or more than 75
    Given  Open page
    When Fill score field
      | Field             | Value         |
      | Age               | 15            |
      | City              | Riga          |
      | Country           | Latvia        |
      | Children count    | 2             |
    Then Assert if possible create acc

  Scenario: Age could be less than 18 or more than 75
    Given  Open page
    When Fill score field
      | Field             | Value         |
      | Age               | 80            |
      | City              | Riga          |
      | Country           | Latvia        |
      | Children count    | 3             |
    Then Assert if possible create acc

  Scenario: Test form shouldn't be registered
    Given  Open page
    When Fill score field
      | Field             | Value         |
      | Age               | 24            |
      | City              | Riga          |
      | Country           | Latvia        |
      | Children count    | 2             |
    Then Assert if possible create acc

  Scenario: Create special characters
    Given  Open page
    When Fill score field
      | Field             | Value         |
      | Age               | 24            |
      | City              | Riga          |
      | Country           | Latvia        |
      | Children count    | 2             |
    Then Assert if possible create acc
#City- write true if Riga, other way false
#Country- write true if Latvia, other way false