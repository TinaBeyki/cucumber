Feature: app login

  Scenario: Crud Services
    Given Create database connection
    When Post req comes to cucumber application
    Then Close connection

# gherkin keywords  -> Scenario, Given, When, Then, And -> all these keywords starts with uppercase
