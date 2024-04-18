Feature: As an ISA I want to search for a Sales Order using the customers ID Text on customer page Dashboard
Scenario Outline:
  Given the user opens "android"  with appium
  And the user navigate to the "url" url
  And the user types "<username>" into  the "usernameTextfield" textField on "login_page" page
  And the user types "<password>" into  the "passwordTextfield" textField on "login_page" page
  And the user clicks the "loginButton" button on "LoginPage" page
  And the verify that web element attribute "agentID" action "contains" text "<agentId>" on "home_page" page
  And the user clicks the "buyNowButton" button on "home_page" page
  And the user types "<orderId>" into  the "passwordTextfield" textField on "login_page" page
  And the user types "<customer_page_text>" into  the "passwordTextfield" textField on "customer_page" page
  And the verify that web element attribute "customerIDText" action "contains" text "<customer_page_text>" on "customer_page" page



  Examples:
  |username              |password        |agentId         |customer_page_text        |
  | test_agent@jdg.co.za |TestingUser_2024|Agent#0000010   |Customer ID               |
