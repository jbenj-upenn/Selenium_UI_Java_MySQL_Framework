package utilities;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    public static void initializeProperties(){
        //here we copy the CONTENT ROOT of our config.properties file
        //try/catch
        try {
            //create a copy of class FileReader and pass the path to it
            //FileReader reads info from files :-)
            //throws an exceptions, hence the try/catch block
            FileReader fileReader = new FileReader("src/test/resources/config.properties");
            properties = new Properties(); //initialize properties object
            properties.load(fileReader); //passing the fileReader created two lines above
        }catch(Exception e){
            e.printStackTrace(); //prints whatever the exception may be
        }
    }

    public static String getConfigProperty(String key) {
        //returning value stored in key passed as a parameter to this method
        return properties.getProperty(key);
    }
}
