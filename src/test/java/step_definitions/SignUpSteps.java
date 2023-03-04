package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SignUpPage;
import pages.SuccessfulRegistrationPage;

public class SignUpSteps {
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage();

    //use loginPage object
    @Given("user clicks on Sign Up Here link")
    public void user_clicks_on_sign_up_here_link() {
        loginPage.clickSignUpHereLink();
    }
    //use signUpPage object
    @When("user enters information in all fields")
    public void user_enters_information_in_all_fields() {
        signUpPage.enterInfoAllFields();
    }
    //use signUpPage object
    @When("user clicks Next button")
    public void user_clicks_next_button() {
        signUpPage.clickNextButton();
    }
    //use signUpPage object
    @When("user enters information in all fields on next page")
    public void user_enters_information_in_all_fields_on_next_page(){
        signUpPage.enterInfoAllFieldsNext();
    }
    //use signUpPage object
    @When("user clicks Register button")
    public void user_clicks_register_button() {
        signUpPage.clickRegisterButton();
    }
    //use successPage object
    @Then("user sees Success message on Sign In page")
    public void user_sees_success_message_on_sign_in_page() throws InterruptedException {
        successfulRegistrationPage.verifySuccessMessage();
    }
}
