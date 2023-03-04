package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SavingsAccountPage;
import pages.ViewSavingsAccountsPage;

public class NewSavingsAccountSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SavingsAccountPage savingsAccountPage = new SavingsAccountPage();
    ViewSavingsAccountsPage viewSavingsAccountsPage = new ViewSavingsAccountsPage();

    @When("user clicks on Savings option in left sidebar")
    public void user_clicks_on_savings_option_in_left_sidebar()  {
        homePage.savingsView();
    }
    @When("user clicks on New Savings option under Savings option")
    public void user_clicks_on_new_savings_option_under_savings_option(){
        homePage.newSavingsView();
    }
    @When("verify user is in Create Savings view")
    public void verify_user_is_in_create_savings_view() {
        savingsAccountPage.verifyCreateSavingsView();
    }
    @When("user selects Savings Account type")
    public void user_selects_savings_account_type() {
        savingsAccountPage.selectSavingsAccount();
    }
    @And("user selects Account Ownership")
    public void user_selects_account_ownership() {
        savingsAccountPage.selectIndividualAccount();
    }
    @And("user enters Account Name")
    public void user_enters_account_name() {
        viewSavingsAccountsPage.enterAccountName();
    }
    @And("user enters Initial Deposit amount")
    public void user_enters_initial_deposit_amount() {
        savingsAccountPage.enterInitialAmount();
    }
    @And("user clicks Submit button")
    public void user_clicks_submit_button() {
        savingsAccountPage.submitNewSavingsAccount();
    }
    @Then("verify user sees View Savings view and the newly created Savings account with On Off button set to On")
    public void verify_user_sees_view_savings_view_and_the_newly_created_savings_account_with_on_off_button_set_to_on()  {
        viewSavingsAccountsPage.verifyViewSavingsPage();
    }
    @When("user clicks View Savings option under Savings option")
    public void user_clicks_view_savings_option_under_savings_option() {
        homePage.savingsView();
        homePage.viewSavingsView();
        viewSavingsAccountsPage.verifyViewSavingsPage();
    }
    @Then("verify new savings account exists")
    public void verify_new_savings_account_exists() {
        viewSavingsAccountsPage.verifyNewSavingsAccount();
    }
}
