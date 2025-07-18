Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given User launches the application
    When User clicks on Login link
    And User enters username "username_SaiAdithya" and password "password_SaiAdithya"
    And User clicks on Login button
    Then User should see Logout link
