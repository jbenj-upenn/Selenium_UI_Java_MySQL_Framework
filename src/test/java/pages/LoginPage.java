package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;
import utilities.DriverUtilities;

public class LoginPage extends BasePage{
    WebDriver dr = DriverUtilities.getDriver();

    //14b. all methods and elements of the Login page will be created here
    @FindBy(xpath = "//div[@class=\"login-logo\"]//img[@src=\"/bank/images/logo.png\"]")
    WebElement loginLogo;

    @FindBy(xpath = "//input[@placeholder=\"Enter User Name\"]")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "remember-me")
    WebElement rememberMeBtn;

    @FindBy(id = "submit")
    WebElement signInBtn;

    //accessed from SignUpSteps creating LoginPage object loginpage
    //loginPage.signUpHereLink.click();
    @FindBy(xpath = "//div[@class=\"register-link m-t-15 text-center\"]//a")
    WebElement signUpHereLink;

    @FindBy(xpath = "//div/span[contains(text(), \"Error\")]")
    WebElement errorSignIn;

    @FindBy(xpath = "//div/span[contains(text(), \"Success\")]")
    WebElement logOutSuccess;


    //15. create new method
    public void enterValidUserNamePassword(){
        if(loginLogo.isDisplayed()) {
            userName.sendKeys("joshuasevendavid@gmail.com");
            passwordInput.sendKeys("340EChestnutSt");
        }
    }
    //method overload with data being read by ConfigReader and data in config.properties
    public void enterValidUserNamePassword(String username, String password){
        if(loginLogo.isDisplayed()) {
            userName.sendKeys(ConfigReader.getConfigProperty("valid.username"));
            passwordInput.sendKeys(ConfigReader.getConfigProperty("valid.password"));
        }
    }

    public void enterInvalidUserNamePassword() {
        if(loginLogo.isDisplayed()) {
            userName.sendKeys(ConfigReader.getConfigProperty("invalid.username"));
            passwordInput.sendKeys(ConfigReader.getConfigProperty("invalid.password"));
        }
    }

    public void enterInvalidUserNamePassword_ScenarioOutline(String invalidUserName, String invalidPassWord) {
        if(loginLogo.isDisplayed()) {
            userName.sendKeys(invalidUserName);
            passwordInput.sendKeys(invalidPassWord);
        }
    }

    public void signInErrorMessage(){
        errorSignIn.isDisplayed();
        Assert.assertTrue("Error message does not appear", errorSignIn.isDisplayed());
    }

    public void clickSignInButton(){
        signInBtn.click();
    }

    public void clickSignUpHereLink(){
        signUpHereLink.click();
    }

    public void selectRememberMe() {
        rememberMeBtn.click();
    }

    public void navigateBack() {
        dr.navigate().back();
    }

    public void userNameRemembered() {
        Assert.assertTrue("User name is not displayed.", userName.isDisplayed());
    }

    public void loggedOut() {
        logOutSuccess.isDisplayed();
    }
    //16a. the next step is to verify that we are on the HomePage, and this requires creating a new class
    //called HomePage


}
