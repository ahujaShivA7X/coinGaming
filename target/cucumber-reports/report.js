$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SauceDemo.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "Navigate to a SauceDemo and validate its functionality",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Buy an article successfully",
  "description": "",
  "id": "login;buy-an-article-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Go to the website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "enter username and password",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Click on the Sign In button",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 8,
      "value": "#Check no.1"
    }
  ],
  "line": 9,
  "name": "User is on the home page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "add an item to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Go to the cart",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "click on Checkout",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "enter firstname, lastname and Zip and click continue",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "click on Finish",
  "keyword": "Then "
});
formatter.match({
  "location": "Checkout.go_to_the_website()"
});
formatter.result({
  "duration": 3100178200,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.enter_username_and_password()"
});
formatter.result({
  "duration": 288693600,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.click_on_the_sign_in_button()"
});
formatter.result({
  "duration": 155368100,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.user_is_on_the_home_page()"
});
formatter.result({
  "duration": 6987900,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.add_an_item_to_the_cart()"
});
formatter.result({
  "duration": 108663400,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.go_to_the_cart()"
});
formatter.result({
  "duration": 109588200,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.click_on_checkout()"
});
formatter.result({
  "duration": 113855400,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.enter_firstname_lastname_and_zip_and_click_continue()"
});
formatter.result({
  "duration": 460636700,
  "status": "passed"
});
formatter.match({
  "location": "Checkout.click_on_finish()"
});
formatter.result({
  "duration": 2811398500,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "User is able to Logout",
  "description": "",
  "id": "login;user-is-able-to-logout",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 19,
      "value": "#Check no. 2"
    }
  ],
  "line": 20,
  "name": "User logs in",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Logs out",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the user should be on login page",
  "keyword": "Then "
});
formatter.match({
  "location": "Logout.user_logs_in()"
});
formatter.result({
  "duration": 2795977600,
  "status": "passed"
});
formatter.match({
  "location": "Logout.logs_out()"
});
formatter.result({
  "duration": 772677000,
  "status": "passed"
});
formatter.match({
  "location": "Logout.the_user_should_be_on_login_page()"
});
formatter.result({
  "duration": 81667800,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Locked user is not able to login",
  "description": "",
  "id": "login;locked-user-is-not-able-to-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 25,
      "value": "#Check no. 3"
    }
  ],
  "line": 26,
  "name": "User logs in using locked out user credentials",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "The user should get an error",
  "keyword": "Then "
});
formatter.match({
  "location": "Locked_User.user_logs_in_using_locked_out_user_credentials()"
});
formatter.result({
  "duration": 2844398300,
  "status": "passed"
});
formatter.match({
  "location": "Locked_User.the_user_should_get_an_error()"
});
formatter.result({
  "duration": 676444000,
  "status": "passed"
});
});