Feature: customers

  Background: Below are the common steps for each scenario
    Given User launch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com"
    And User enters Email as " admin@yourstore.com " and Password as "admin"
    Then Click omn login
    Then User can view dashboard


  Scenario: Add a new customer
    When User click on customer menu
    And Click on customer menu item
    Then click on add new buttton
    Then User can view Add new customer page
    When User enter customer info
    And Click on save button


Scenario: Search customer by emailID
  When User click on customer menu
  And Click on customer menu item
  And Enter customer Email
  When Click on search button
  And Close browser

Scenario: Search customer by Name
  When User click on customer menu
  And Click on customer menu item
  And Enter customer firstname
  And Enter customer lastname
  Then Click on search button
  Then User should found name in the search table
  And Close browser
