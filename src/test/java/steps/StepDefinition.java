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
import pages.*;
import utils.DocumentUtils;

import java.io.IOException;

public class StepDefinition {
    private WebDriver driver;
    private LogInPage logInPage;
    private HomePage homePage;
    private LeavePage leavePage;
    private MyInfoPage myInfoPage;
    private AdminPage adminPage;
    private PIMPage pimPage;


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
        myInfoPage = PageFactory.initElements(driver, MyInfoPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        pimPage = PageFactory.initElements(driver, PIMPage.class);
        leavePage = PageFactory.initElements(driver, LeavePage.class);
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
    public void login(String credentials) {
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
    public void clickLeaveLink() {
        homePage.clickLeaveLink();
    }

    @And("user selects the Rejected status from the 'Show Leave with Status' section")
    public void selectRejectedStatus() {
        leavePage.selectRejectedStatus();

    }

    @Then("user checks that the Rejected status is present as a selection")
    public void verifyRejectedStatusIsSelected() {
        Assert.assertTrue("The rejected status was not successfully selected.", leavePage.findIfRejectedStatusIsSelected());
    }

    @And("the user navigates to the 'My Info' page from the menu")
    public void clickMyInfoLink() {
        homePage.clickMyInfoLink();
    }

    @And("the user clicks on the 'Contact Details' link which will redirect to the 'Contact Details' page")
    public void clickContactDetailsPage() {
        myInfoPage.clickContactDetailsLink();
    }

    @And("the user clicks the 'Add Attachments' button")
    public void clickAddAttachmentButton() {
        myInfoPage.clickAddAttachmentButton();
    }

    @And("the user selects to upload a file")
    public void uploadFile() {
        myInfoPage.addDocumentToContactDetails();
    }

    @And("the user adds a comment for this document uploaded in the comment field")
    public void addCommentForUploadedDocument() {
        myInfoPage.leaveComment();
    }

    @And("the user presses the Save button for this attachment added")
    public void pressSaveButtonForAttachment() {
        myInfoPage.clickSaveAttachmentButton();
    }

    @Then("the user will be able to see the document added in the record found section")
    public void verifyAttachmentAddedSuccessfully() {
        Assert.assertTrue("The attachment was not added successfully.", myInfoPage.verifyAttachmentIsAdded());
    }

    @And("the user updates the Street 1 field from contact details")
    public void updateStreetField() {
        myInfoPage.insertStreet1();
    }

    @And("the user selects Algeria as country")
    public void selectAlgeriaAsCountry() {
        myInfoPage.clickCountryField();
        myInfoPage.selectAlgeriaCountryOption();
    }

    @And("the user presses the Save button")
    public void saveUpdatedContactDetails() {
        myInfoPage.clickSaveContactDetailsBtn();
    }

    @And("the user should see the successfully updated confirmation message")
    public void verifyContactDetailsUpdatedSuccessfully() {
        Assert.assertTrue("The contacts details were not updated successfully.", myInfoPage.verifyContactDetailsSuccessfullyUpdated());
    }

    @And("the user ticks the checkbox to select one record saved in the Records Found section")
    public void tickCheckboxOfRecordToBeDeleted() {
        myInfoPage.clickRecordCheckBox();
    }

    @And("the user presses the 'Delete' button to delete that record")
    public void clickDeleteRecordButton() {
        myInfoPage.clickDeleteSelectedRecordsBtn();
    }

    @And("the user selects 'Yes' to confirm the deletion")
    public void confirmAlertOfRecordDeletion() {
        myInfoPage.acceptAlertOfDeletion();
    }

    @Then("the user should receive a confirmation message that the record has been deleted successfully")
    public void verifyRecordIsDeletedSuccessfully() {
        Assert.assertTrue("The record was not deleted succesfully.", myInfoPage.verifyContactRecordSuccessfullyDeleted());
    }

    @And("the user navigates to the 'Admin' link from the menu")
    public void navigateToAdminPage() {
        homePage.clickAdminLink();
    }

    @And("the user clicks on the 'Configuration' dropdown menu button")
    public void clickConfigurationButton() {
        adminPage.clickConfigurationDropdownBtn();
    }

    @And("the user selects the 'Language Packages' option")
    public void selectLanguagePackageOption() {
        adminPage.selectLanguagePackages();
    }

    @And("the user clicks on the 'Translate' button for 'Spanish - Español' language package")
    public void clickSpanishTranslateButton() {
        adminPage.clickSpanishTranslateBtn();
    }

    @Then("the user should be redirected to the Language Customization page")
    public void verifyRedirectToLanguageCustomizationIsSuccessful() {
        Assert.assertTrue("The redirect to Language Customization page is not succesful", adminPage.verifyRedirectToLanguageCustomizationPage());
    }

    @And("the user clicks the 'Add' button to add a new language to the packages")
    public void addNewLanguagePackage() {
        adminPage.clickAddNewLanguageBtn();
    }

    @And("the user selects a new language from that list")
    public void selectColognianLanguagePackage() {
        adminPage.clickLanguageSelector();
        adminPage.selectANewLanguage();
    }

    @And("the user presses the 'Save' to add this new language to my packages")
    public void saveLanguageSelection() {
        adminPage.clickSaveLanguageSelectionBtn();
    }

    @Then("the user should be able to see the confirmation message that the language was successfully saved")
    public void verifyLanguageIsAddedSuccesfully() {
        Assert.assertTrue("The language was not added", adminPage.verifyLanguageIsSuccessfullyAdded());
    }

    @When("the user selects the 'Change Password' option from drop-down user profile menu")
    public void selectChangePasswordOptionFromUserDropdown() {
        homePage.clickChangePasswordBtn();
    }

    @And("the user enters the current password in the 'Current Password' field")
    public void completeCurrentPasswordField() {
        pimPage.insertCurrentPassword();
    }

    @And("the user enters in the 'Password field' a new password")
    public void completeNewPasswordField() {
        pimPage.insertNewPassword();
    }

    @And("the user confirms the new password")
    public void confirmNewPassword() {
        pimPage.insertNewPasswordAgainToConfirm();
    }

    @And("the user presses the Save button to update the password")
    public void clickSavePasswordChangesButton() {
        pimPage.clickSaveBtn();
    }

    @Then("the user should be able to see the confirmation message")
    public void verifyPasswordIsChangedSuccessfully() {
        Assert.assertTrue("The password is not changed successfully.", pimPage.verifyPasswordIsChangedSuccessfully());
    }

    @And("the user clicks on the button with three dots which is located in the left corner for an employee record")
    public void clickRecordsThreeDots() {
        leavePage.clickThreeDotsRecordBtn();
    }

    @And("the user selects to Add Comment from that list")
    public void selectAddCommentOption() {
        leavePage.clickAddCommentBtn();
    }

    @And("the user enters a comment in the Leave Request Comments section")
    public void introduceComment() {
        leavePage.introduceCommentForRecord();
    }

    @And("the user saves the comment")
    public void saveComment() {
        leavePage.clickSaveCommentBtn();
    }

    @Then("the user should be able to see the confirmation message that the comment was added successfully")
    public void verifyConfirmationMessageForAddedComment() {
        Assert.assertTrue("The confirmation message is not displayed.", leavePage.verifyConfirmationMessageIsDisplayed());
    }

    @And("the user should also be able to see the comment after refreshing the page")
    public void verifyCommentIsAddedToRecord() throws IOException {
        leavePage.refreshPage();
        Assert.assertTrue("The comment message was not added successfully", leavePage.verifyCommentIsAdded());
    }
}
