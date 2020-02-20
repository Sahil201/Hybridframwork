Feature: Login

  Scenario: successful login with valid credentials
    Given User launch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com"
    And User enters Email as " admin@yourstore.com " and Password as "admin"
    Then Click omn login
    And Page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

  Scenario Outline: Login Data Driven
    Given User launch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com"
    And User enters Email as " <email> " and Password as "<password>"
    Then Click omn login
    And Page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

    Examples:
        |email| password |
        |admin@yourstore.com| admin|
        |admin1@yourstores.com| admin123|
