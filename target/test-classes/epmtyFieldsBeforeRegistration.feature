
Feature: Check if field are empty before registration

Background:
  Given We open page qaguru

  Scenario: Check name field
    When We press on link Add User
    Then Field with name should be empty


  Scenario: Check surname field
    When We press on link Add User
    Then Field with surname should be empty


  Scenario: Check phone field
    When We press on link Add User
    Then Field with phone should be empty

  Scenario: Check email field
    When We press on link Add User
    Then Field with email should be empty


  Scenario: Check personId field
    When We press on link Add User
    Then Field with personId should be empty


  Scenario: Check if score fields are empty
    When Navigate to add score form
    Then Field age is empty
    Then Field city is empty
    Then Field country is empty
    Then Field children count is empty

