package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class CommonMethods {

    public static byte[] takeScreenshot() {
        //taking screenshots to add to our reports
        //we pass the driver to the TakeScreenshot interface
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverUtilities.getDriver();
        //creating a BYTE ARRAY of the pixels of the screenshot
        //a picture of code is just an array of data
        //it can also be saved as a FILE
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static void takeScreenshot(Scenario scenario) {
        //Surrounding whole block in try-catch in order to catch and print error if screenshot fails
        try {
            if (scenario.isFailed()) {
                File screenshot = ((TakesScreenshot) DriverUtilities.getDriver()).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File("target/automation/screenshots/" + scenario.getName() + ".png"));
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("The error happened while taking screenshot and cleaning up after the test");
            e.getMessage();
        }
    }
}