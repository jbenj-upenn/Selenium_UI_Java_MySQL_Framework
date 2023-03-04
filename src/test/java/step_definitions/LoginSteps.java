package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    //17.create objects of classes
    //we're creating objects rather than extending because a class cannot extend multiple classes
    //in our methods, we will call our objects and use methods that exist in the pages (LoginPage and HomePage)

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    //10b. paste our steps and import annotations
    @Given("user enters valid {string} and {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.enterValidUserNamePassword(username, password);
    }

    @Given("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterValidUserNamePassword();
    }

    @When("user clicks on Sign In button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickSignInButton();
    }

    @Then("verify user is successfully logged in to their account")
    public void verify_user_is_successfully_logged_in_to_their_account() {
        homePage.verifyHomePage();
    }

    @Given("user enters invalid {string} and {string}")
    public void user_enters_invalid_username_or_password(String username, String password) {
        loginPage.enterInvalidUserNamePassword();
    }

    @Given("user enters invalid username {string} and or invalid password {string}")
    public void user_enters_invalid_username_and_or_invalid_password(String invalidUserName, String invalidPassWord) {
        loginPage.enterInvalidUserNamePassword_ScenarioOutline(invalidUserName, invalidPassWord);
    }

    @Then("verify user is unable to login")
    public void verify_user_is_unable_to_login()  {
        loginPage.signInErrorMessage();
    }

    @When("user selects Remember Me button")
    public void user_selects_remember_me_button() {
        loginPage.selectRememberMe();
    }

    //    @When("user clicks avatar")
//    public void user_clicks_avatar() throws InterruptedException{
//        homePage.avatarDropDown();
//        Thread.sleep(1500);
//    }
//    @When("user selects logout")
//    public void user_selects_logout() throws InterruptedException {
//        homePage.logout();
//        Thread.sleep(1500);
//    }
//    @When("verify user is logged out")
//    public void verify_user_is_logged_out() throws InterruptedException {
//        loginPage.loggedOut();
//        Thread.sleep(1500);
//    }
    @When("user clicks back button")
    public void user_clicks_back_button() {
        loginPage.navigateBack();
    }

    @Then("verify username appears in user name field")
    public void verify_username_appears_in_user_name_field() {
        loginPage.userNameRemembered();
    }
}
//11a. Create Hooks class
