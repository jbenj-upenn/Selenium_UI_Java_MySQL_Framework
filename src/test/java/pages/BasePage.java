package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.DriverUtilities;

public class BasePage {
    //12b. set up WebDriver variable because every other page class will inherit this driver
    WebDriver dr = DriverUtilities.getDriver();

    //13. Create BasePage constructor
    //create PageFactory
    public BasePage(){
        //Pass the driver and the keyword 'this' because our pages are in classes and are inheriting
        //It dynamically initializes the WebElements on the page
        //.initElements() method initializes elements; we need to pass driver and object page we want to initialize
        PageFactory.initElements(dr, this);

    }
}
//14a. Move on to LoginPage
//all elements and methods for a given page are dealt with in separate classes