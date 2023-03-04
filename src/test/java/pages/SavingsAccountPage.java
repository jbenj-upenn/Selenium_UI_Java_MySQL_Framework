package pages;

import com.github.javafaker.Faker;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;
import utilities.DriverUtilities;

import java.util.List;

public class SavingsAccountPage extends BasePage{
    WebDriver dr = DriverUtilities.getDriver();
    Faker faker = new Faker();
    String account = faker.name().lastName() + " Savings";

    @FindBy(xpath = "//div[@class=\"page-title\"]/h1[@id=\"page-title\"]")
    WebElement createSavings;
// CREATE SAVINGS ELEMENTS
    @FindBy(xpath = "//label[@for=\"Savings\"]/input")
    WebElement savingsRadioButton;
    @FindBy(xpath = "//label[@for=\"Money Market\"]/input")
    WebElement moneyMarketRadioButton;
    @FindBy(xpath = "//label[@for=\"Individual\"]/input")
    WebElement individualAccount;
    @FindBy(xpath = "//label[@for=\"Joint\"]/input")
    WebElement jointAccount;
//    @FindBy(xpath = "//input[@id=\"name\"]")
//    WebElement accountName;
    @FindBy(xpath = "//input[@id=\"openingBalance\"]")
    WebElement initialDeposit;
    @FindBy(xpath = "//button[@id=\"newSavingsSubmit\"]")
    WebElement submitNewSavingsButton;
    @FindBy(xpath = "//button[@id=\"newSavingsReset\"]")
    WebElement resetNewSavingsButton;
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1[contains(text(), \"View Savings Accounts\")]")
    WebElement viewSavingsTitles;


    public void verifyCreateSavingsView() {
        Assert.assertTrue("You are not in Create Savings View.", createSavings.isDisplayed());
    }
    public void selectSavingsAccount() {
        savingsRadioButton.click();
    }
    public void selectMoneyMarketAccount() {
        moneyMarketRadioButton.click();
    }
    public void selectIndividualAccount() {
        individualAccount.click();
    }
    public void selectJointAccount() {
        jointAccount.click();
    }
//    public void enterAccountName() {
//        accountName.sendKeys(account);
//    }
    public void enterInitialAmount() {
        initialDeposit.sendKeys(ConfigReader.getConfigProperty("savings.initialDeposit"));
    }
    public void submitNewSavingsAccount() {
        submitNewSavingsButton.click();
    }
    public void resetNewSavingsAccountInfo() {
        resetNewSavingsButton.click();
    }
}
