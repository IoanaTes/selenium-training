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
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import pages.ContactDetailsPage;
import pages.HomePage;
import pages.LogInPage;
import pages.MyInfoPage;
import utils.DocumentUtils;

import java.io.IOException;

public class StepDefinition {
    private WebDriver driver;
    private LogInPage logInPage;
    private HomePage homePage;
    private MyInfoPage myInfoPage;
    private ContactDetailsPage contactDetailsPage;

//    ExtentReports reports = new ExtentReports();
//
//    ExtentTest test = reports.


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
        myInfoPage = PageFactory.initElements(driver, MyInfoPage.class);
        contactDetailsPage = PageFactory.initElements(driver, ContactDetailsPage.class);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("the user accesses the website")
    public void accessWebsite() throws IOException {
        driver.get(DocumentUtils.getPropertiesFile().getProperty("url"));
    }

    @And("^the user introduces the \"(.*)\"$")
    public void login(String credentials){
        if (credentials.equals("valid credentials"))
            logInPage.setCredentials("correct username");
        else if (credentials.equals("invalid credentials")) {
            logInPage.setCredentials("incorrect username");
        }
    }

    @When("the user clicks on Login button")
    public void clickLogInButton() {
        logInPage.clickLoginBtn();
    }

    @Then("^the user should be \"(.*)\" logged in$")
    public void verifyLogin(String outcome) {
        if (outcome.equals("successfully")) {
            Assert.assertTrue("Login was not successful.", homePage.isLoginSuccessful());
        } else if (outcome.equals("not successfully")) {
            Assert.assertTrue("Login was successful.", logInPage.areCredentialsInvalid());
        }
    }
    @When("user clicks the Leave link from the menu")
    public void clickLeaveLink(){
        homePage.clickLeaveLink();
    }
    @And("user selects the Rejected status from the 'Show Leave with Status' section")
    public void selectRejectedStatus() throws InterruptedException {
        homePage.selectRejectedStatus();

    }
    @Then("user checks that the Rejected status is present as a selection")
    public void verifyRejectedStatusIsSelected(){
       Assert.assertTrue("The rejected status was not successfully selected.",homePage.findIfRejectedStatusIsSelected());
    }
    @And("the user clicks the 'My Info' option on the menu")
    public void clickMyInfoLink(){
        homePage.clickMyInfoLink();
    }
    @And("the user clicks on the 'Contact Details' link which will redirect to the 'Contact Details' page")
    public void clickContactDetailsPage(){
        myInfoPage.clickContactDetailsLink();
    }
    @And("the user clicks the 'Add Attachments' button")
    public void clickAddAttachmentButton(){
        contactDetailsPage.clickAddAttachmentButton();
    }
    @And("the user selects to upload a file")
    public void uploadFile(){
        contactDetailsPage.addDocumentToContactDetails();
    }
    @And("the user adds a comment for this document uploaded in the comment field")
    public void addCommentForUploadedDocument(){
        contactDetailsPage.leaveComment();
    }
    @And("the user presses the Save button for this attachment added")
    public void pressSaveButtonForAttachment(){
        contactDetailsPage.clickSaveAttachmentButton();
    }
    @Then("the user will be able to see the document added in the record found section")
    public void verifyAttachmentAddedSuccessfully(){
       Assert.assertTrue("The attachment was not added successfully.",contactDetailsPage.verifyAttachmentIsAdded());
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

