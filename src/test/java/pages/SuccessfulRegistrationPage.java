package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulRegistrationPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(), \"Registration Successful. Please Login.\")]")
    WebElement successMessage;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "remember-me")
    WebElement rememberMe;
    @FindBy(id = "submit")
    WebElement signIn;

    public void verifySuccessMessage() {
        Assert.assertTrue("You have not successfully signed up; missing \"Success\" message", successMessage.isDisplayed());
    }
}
