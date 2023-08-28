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

    @When("the user presses on Login button")
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
    public void selectRejectedStatus(){
        homePage.selectRejectedStatus();

    }
    @Then("user checks that the Rejected status is present as a selection")
    public void verifyRejectedStatusIsSelected(){
       Assert.assertTrue("The rejected status was not successfully selected.",homePage.findIfRejectedStatusIsSelected());
    }
    @And("the user navigates to the 'My Info' page from the menu")
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
    @And("the user updates the Street 1 field from contact details")
    public void updateStreetField(){
        contactDetailsPage.insertStreet1();
    }
    @And("the user selects Algeria as country")
    public void selectAlgeriaAsCountry(){
        contactDetailsPage.clickCountryField();
        contactDetailsPage.selectAlgeriaCountryOption();
    }
    @And("the user presses the Save button")
    public void saveUpdatedContactDetails(){
        contactDetailsPage.clickSaveContactDetailsBtn();
    }
    @And("the user should see the successfully updated confirmation message")
    public void verifyContactDetailsUpdatedSuccessfully(){
        Assert.assertTrue("The contacts details were not updated successfully.",contactDetailsPage.verifyContactDetailsSuccessfullyUpdated());
    }
    @And("the user ticks the checkbox to select one record saved in the Records Found section")
    public void tickCheckboxOfRecordToBeDeleted() throws InterruptedException {
        Thread.sleep(10000);
        contactDetailsPage.clickRecordCheckBox();
    }
    @And("the user presses the 'Delete' button to delete that record")
    public void clickDeleteRecordButton(){
        contactDetailsPage.clickDeleteSelectedRecordsBtn();
    }
    @And("the user selects 'Yes' to confirm the deletion")
    public void confirmAlertOfRecordDeletion() throws InterruptedException {
        Thread.sleep(5000);
        contactDetailsPage.acceptAlertOfDeletion();
    }
    @Then("the user should receive a confirmation message that the record has been deleted successfully")
    public void verifyRecordIsDeletedSuccessfully(){
       Assert.assertTrue("The record was not deleted succesfully.",contactDetailsPage.verifyContactRecordSuccessfullyDeleted());
    }
}
