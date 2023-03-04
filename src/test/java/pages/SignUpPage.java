package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;

public class SignUpPage extends BasePage {
    // All methods and elements of the SignUp page will be created here
    @FindBy(xpath = "//div[@class=\"login-logo\"]//img[@src=\"images/logo.png\"]")
    WebElement signUpLogo;
    @FindBy(css = "div select")
    WebElement titleDrop;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(xpath = "//input[@value=\"M\"]")
    WebElement genderMale;
    @FindBy(xpath = "//input[@id=\"dob\"]")
    WebElement dob;
    @FindBy(id = "ssn")
    WebElement ssn;
    @FindBy(id = "emailAddress")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-flat m-b-30 m-t-30\"]")
    WebElement nextButton;
    @FindBy(xpath = "//img[@src=\"/bank/images/logo.png\"]")
    WebElement signUpLogo2;
    @FindBy(id = "address")
    WebElement address;
    @FindBy(id = "locality")
    WebElement locality;
    @FindBy(id = "region")
    WebElement region;
    @FindBy(id = "postalCode")
    WebElement zipCode;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "homePhone")
    WebElement homePhone;
    @FindBy(id = "mobilePhone")
    WebElement mobilePhone;
    @FindBy(id = "workPhone")
    WebElement workPhone;
    @FindBy(xpath = "//input[@id=\"agree-terms\"]")
    WebElement agreeTerms;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement registerButton;

    Faker faker = new Faker();
//    public void clickSignUpHere() throws InterruptedException{
//        LoginPage loginPage = new LoginPage();
//        loginPage.signUpHereLink.click();
//        Thread.sleep(2000);
//    }

    public void enterInfoAllFields() {
        if(signUpLogo.isDisplayed()){

            Select title = new Select(titleDrop);
            title.selectByVisibleText("Mr.");
            firstName.sendKeys(faker.name().firstName());
            lastName.sendKeys(faker.name().lastName());
            genderMale.click();
            dob.sendKeys(ConfigReader.getConfigProperty("valid.dob"));
            ssn.sendKeys(faker.idNumber().ssnValid());
            email.sendKeys(faker.internet().emailAddress());
            String fakerPassword = faker.internet().password();
            password.sendKeys(fakerPassword);
            confirmPassword.sendKeys(fakerPassword);
        }
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public void enterInfoAllFieldsNext() {
        if (signUpLogo2.isDisplayed()) {
            address.sendKeys("33 Regression St.");
            locality.sendKeys("San Luis Obispo");
            region.sendKeys("CA");
            zipCode.sendKeys("93401");
            country.sendKeys("USA");
            homePhone.sendKeys("8059893322");
            mobilePhone.sendKeys("8059894433");
            workPhone.sendKeys("");
            agreeTerms.click();
        }
    }
        public void clickRegisterButton(){
            registerButton.click();
        }
//        public void successMessageSignUpPage() throws InterruptedException{
//            SuccessfulRegistrationPage successfulRegistration = new SuccessfulRegistrationPage();
//            successfulRegistration.verifySuccessMessage();
//        }
    }
