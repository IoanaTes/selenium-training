package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LogInPage;
import utils.DocumentUtils;

import java.io.IOException;

public class StepDefinition {
    private WebDriver driver;
    private LogInPage logInPage;
    private HomePage homePage;


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/iteslarasu/Desktop/AutomationTrainingProject/selenium-training/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        logInPage = PageFactory.initElements(driver, LogInPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("I access the website")
    public void accessWebsite() throws IOException {
        driver.get(DocumentUtils.getPropertiesFile().getProperty("url"));
    }

    @And("I use the correct credentials")
    public void loginWithCorrectCredentials() {
        logInPage.setUsernameField();
        logInPage.setPasswordField();
    }

    @When("I click on Sign In button")
    public void clickLogInButton() {
        logInPage.clickLoginBtn();
    }

    @Then("I should be logged in successfully")
    public void verifySuccessfulLogin() {
        Assert.assertTrue("Logged in successfully", homePage.isLoginSuccessful());
    }

}


//    public static void main(String[] args) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "/Users/iteslarasu/Desktop/AutomationTrainingProject/selenium-training/chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--disable-notifications");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//        String title = driver.getTitle();
//        Thread.sleep(5000);
//        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//
//        System.out.println(loginBtn.getAttribute("type"));
//        System.out.println(title);
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.findElement(By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title")).getText());
//        System.out.println(loginBtn.isEnabled());
//        System.out.println(loginBtn.isDisplayed());
//        System.out.println(loginBtn.isSelected());
//        Assert.assertEquals("Login", loginBtn.getText());
//        Assert.assertTrue("Login button is displayed", loginBtn.isDisplayed());
//
//        driver.quit();
//
//    }

