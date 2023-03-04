package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//16b. create verification of HomePage
public class HomePage extends BasePage {
    // HOMEPAGE WELCOME NAME ELEMENT
    @FindBy(xpath = "//li[@class=\"active\"]")
    WebElement welcomeName;

    // AVATAR ELEMENTS******************************
    @FindBy(xpath = "//img[@class=\"user-avatar rounded-circle\"]")
    WebElement avatar;
    @FindBy(xpath = "//div[@class=\"user-menu dropdown-menu show\"]/a[1]")
    WebElement myProfile;
    @FindBy(xpath = "//div[@class=\"user-menu dropdown-menu show\"]/a[2]")
    WebElement changePassword;
    @FindBy(xpath = "//div[@class=\"user-menu dropdown-menu show\"]/a[1]")
    WebElement logOut;

    // LEFT SIDEBAR ELEMENTS******************************
    @FindBy(xpath = "//a[@class=\"navbar-brand\"]/img")
    WebElement digitalBankIcon;
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a/i[@class=\"menu-icon fa fa-home\"]")
    WebElement home;
    // CHECKING ELEMENTS******************************
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[2]/a/i")
    WebElement checking;
    // SAVINGS ELEMENTS******************************
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[3]/a/i")
    WebElement savings;
    @FindBy(xpath = "//a[contains(text(), \"View Savings\")]")
    WebElement viewSavings;
    @FindBy(xpath = "//a[contains(text(), \"New Savings\")]")
    WebElement newSavings;
    // EXTERNAL ELEMENTS******************************
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[4]/a/i")
    WebElement external;
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[5]/a/i")
    WebElement deposit;
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[6]/a/i")
    WebElement withdraw;
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[7]/a/i")
    WebElement transfer;
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li[8]/a/i")
    WebElement visaDirectTransfer;


    public void verifyHomePage() {
        Assert.assertFalse("You are not on the homepage; missing \"Welcome\" message", welcomeName.isDisplayed());
    }

    // USER AVATAR DROPDOWN METHODS******************************
    public void avatarDropDown() {
        avatar.click();
    }

    public void viewMyProfile() {
        myProfile.click();
    }

    public void changeMyPassword() {
        changePassword.click();
    }

    public void logout() {
        logOut.click();
    }

    //LEFTHAND SIDEBAR METHODS******************************
    public void checkingView() {
        checking.click();
    }

    public void savingsView() {
        savings.click();
    }

    public void viewSavingsView() {
        viewSavings.click();
    }

    public void newSavingsView() {
        newSavings.click();
    }

    public void externalView() {
        external.click();
    }

    public void deposit() {
        deposit.click();
    }

    public void withdraw() {
        withdraw.click();
    }

    public void transfer() {
        transfer.click();
    }

    public void visaDirectXfer() {
        visaDirectTransfer.click();
    }
}
