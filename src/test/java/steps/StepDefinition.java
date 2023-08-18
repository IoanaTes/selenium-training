package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {
//    private WebDriver driver;

//    @Before
//    public void before() {
//        driver = new ChromeDriver();
//        WebDriverManager.chromedriver().setup();
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void after() {
//        driver.quit();
//    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title = driver.getTitle();
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        String loginBtnAttribute = loginBtn.getAttribute("type");
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title")).getText());
        System.out.println(loginBtnAttribute);

        driver.close();
        driver.quit();

    }
}
