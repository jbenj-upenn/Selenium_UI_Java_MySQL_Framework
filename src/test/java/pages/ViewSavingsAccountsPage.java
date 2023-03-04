package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewSavingsAccountsPage extends BasePage {
    //    WebDriver dr = DriverUtilities.getDriver();
    Faker faker = new Faker();
    String account = faker.name().lastName() + " Savings";

    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement accountName;
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1[contains(text(), \"View Savings Accounts\")]")
    WebElement viewSavingsTitle;

    //List of Accounts
    List<WebElement> accounts = dr.findElements(By.xpath("//*[@class='h4 m-0']"));

    public void enterAccountName() {
        accountName.sendKeys(account);
    }

    public void verifyViewSavingsPage() {
        Assert.assertTrue("This is not the page to view savings accounts", viewSavingsTitle.isDisplayed());
//        Assert.assertTrue("No Success message displayed", successMessage.isDisplayed());
    }

    public void verifyNewSavingsAccount() {
        for (WebElement target : accounts) {
            System.out.println(accounts);
            System.out.println(target);
            System.out.println(target.getText());
            if (target.getText().equalsIgnoreCase(account)) {
                System.out.println(target.getText());
            } else {
                System.out.println("Can't get Account name with savingsAccountPage.account.");
            }
        }

        System.out.println(account);
    }
}
