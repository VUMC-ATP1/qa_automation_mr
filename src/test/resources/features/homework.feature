Feature: Checkout feature for SauceDemo
  As a user,
  I want to be able to login
  So I can add products to cart
  and proceed to the checkout.
  Also recieve all error messages

  Scenario:Successfully completing checkout for product
    Given I have to navigate to SauceDemo web site
    When I login with the "standard_user" and "secret_sauce"
    Then I am successfully logged in SauceDemo

    Given I am logged in SauceDemo
    When I add to cart one Sauce Labs Bike Light pressing Add to Cart button
    Then I go to check the Cart page

    Given I am successfully redirected to Cart page
    And  I check if one Sauce Labs Bike Light is added in the shopping cart
    When I press Checkout button
    Then I am redirected to Checkout page

    Given I am successfully redirected to Checkout page
    When I populate all field with the required information
    And  Press Continue button
    Then I am redirected to Checkout: Overview page

    Given I am successfully redirected to Checkout: Overview page
    When I press Finish button
    Then I am redirected to Checkout: Complete page

    Given I am successfully redirected to Checkout: Complete page
    When I press Back Home button
    Then I am redirected to the first page


  Scenario Outline: Checking if correct error messages appears in Checkout page
    Given I have to navigate to SauceDemo web site
    When I login with the "standard_user" and "secret_sauce"
    Then I am successfully logged in SauceDemo

    Given I am logged in SauceDemo
    When I click on Cart icon
    Then I am redirected to Cart page

    Given I am at Cart page
    When I press Checkout button
    Then I am redirected to Checkout page

    Given I am successfully redirected to Checkout page
    When I populate all required fields '<firstname>', '<lastname>' and '<zip_postalcode>'
    And  Press Continue button
    Then I receive Error message: '<error_message>'

    Examples:
      |firstname|lastname|zip_postalcode|error_message                  |
      |         |Pen     |LV1024        |Error: First Name is required  |
      |Peter    |        |LV1024        |Error: Last Name is required   |
      |Peter    |Pen     |              |Error: Postal Code is required |



