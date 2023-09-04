package utils;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.util.Properties;

public class DocumentUtils {

    private WebDriver driver;

    public DocumentUtils(WebDriver driver) {
        this.driver = driver;
    }
        public static Properties getPropertiesFile() throws IOException {
            FileReader reader = new FileReader("src/test/resources/utils/test.properties");
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        }

    }


