package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
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


