Feature: Login
  Navigate to a SauceDemo and validate its functionality

  Scenario: Buy an article successfully
    Given Go to the website
    And enter username and password
    Then Click on the Sign In button
    #Check no.1
    And User is on the home page
    And add an item to the cart
    And Go to the cart
    And click on Checkout
    And enter firstname, lastname and Zip and click continue
    Then click on Finish



  Scenario: User is able to Logout
    #Check no. 2
    Given User logs in
    And Logs out
    Then the user should be on login page

  Scenario: Locked user is not able to login
    #Check no. 3
    Given User logs in using locked out user credentials
    Then The user should get an error


