package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by son.nguyen on 4/30/17.
 */
public class PropertiesFileReader {

    private Properties properties;

    public static void main(String[] args) {
        try {
            PropertiesFileReader propertiesFileReader = new PropertiesFileReader("/Users/son.nguyen/Desktop/Curiosity/src/main/java/selenium/input.properties");
            System.out.println(propertiesFileReader.getProperty("name"));
            System.out.println(propertiesFileReader.getProperty("course"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PropertiesFileReader(String filePath) throws IOException {
        this.properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        this.properties.load(inputStream);
        inputStream.close();
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
