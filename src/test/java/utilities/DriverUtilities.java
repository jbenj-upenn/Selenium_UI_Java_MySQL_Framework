package utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class DriverUtilities {
    //1. create static WebDriver variable
    static WebDriver dr;

    //2. public static void createDriver() method
    public static void createDriver(Scenario scenario) {
        //3. System.setProperty using Content Root path
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        //If localhost, run tests on our local machine
        //else, if value of app.host is saucelabs, we set up remote driver to run tests on Sauce Labs
        if(ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("localhost")) {
            switch (ConfigReader.getConfigProperty("app.browser")) {
                //4. Initialize our driver
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    dr = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    dr = new FirefoxDriver();
                    break;
                //DOWNLOAD SAFARI or this won't work
//            case "safari":
//                WebDriverManager.safaridriver().setup();
//                dr = new SafariDriver();
//                break;
                default:
                    WebDriverManager.chromedriver().setup();
                    dr = new ChromeDriver();
            }
        }else if(ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("saucelabs")){
            // Mutable Capabilities: settings and values that the driver requires
            // This saves our username and accesskey
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigReader.getConfigProperty("sauce.userName"));
            sauceOptions.setCapability("accesskey", ConfigReader.getConfigProperty("sauce.accessKey"));
            //This sets up browser, version, etc. that we want Sauce Labs to use
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", ConfigReader.getConfigProperty("sauce.browserName"));
            capabilities.setCapability("browserVersion", ConfigReader.getConfigProperty("sauce.browserVersion"));
            capabilities.setCapability("platformName", ConfigReader.getConfigProperty("sauce.platformName"));
            capabilities.setCapability("sauce:options", sauceOptions);
            capabilities.setCapability("name", scenario.getName());

            try {
                //Here we are initializing the WebDriver to a Remote driver and passing the URL to the Selenium grid hub
                //and passing the necessary capabilities
                dr = new RemoteWebDriver(new URL(ConfigReader.getConfigProperty("sauce.urlWest")), capabilities);
                //Here we cast the dr driver into JavascriptExecutor and use .executeScript() method to pass the
                //scenario's name to saucelabs
                ((JavascriptExecutor)dr).executeScript("sauce:job-name=" + scenario.getName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //5. Maximize our window so none of the elements are out of the scope of the viewport
        dr.manage().window().maximize();
        //6. Implicit Waits
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //7. Driver .get()
        //removed explicit URL and replaced with info from config.properties file
        dr.get(ConfigReader.getConfigProperty("app.baseurl"));
    }


    public static void quitDriver(Scenario scenario){
        //saying that IF the test is running remotely, we want to send a pass/fail message
        //the IF-ELSE version is commented out below; says the same thing
        if(ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("saucelabs")){
            ((JavascriptExecutor)dr).executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
        }
        dr.quit();
    }

    public static void closeDriver(){
        dr.close();
        dr.quit();
    }

    // THE TERNARY OPERATOR ABOVE DOES THE SAME THING AS THE IF-ELSE STATEMENT BELOW
//    public static void quitDriver(Scenario scenario){
//        //saying that IF the test is running remotely, we want to send a pass/fail message
//        if(ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("saucelabs")){
//            if(scenario.isFailed()){
//                ((JavascriptExecutor)dr).executeScript("sauce:job-result= FAILED");
//            }else{
//                ((JavascriptExecutor)dr).executeScript("sauce:job-result= PASSED");
//            }
//        }


    //8. public static WebDriver getDriver() method
    public static WebDriver getDriver() {
        return dr;
    }
    //9a. Features folder and files in Resources
}
