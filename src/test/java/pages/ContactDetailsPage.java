package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;

public class ContactDetailsPage extends BasePage {

    private WebDriver driver;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--text")
    private WebElement addAttachmentBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement browseBtn;
    @FindBy(xpath = "//textarea")
    private WebElement commentAttachmentArea;
    @FindBy(xpath = "//div[@class='orangehrm-attachment']//button[@type='submit']")
    private WebElement saveAttachmentBtn;
    @FindBy(css = "[class=\"oxd-table-cell oxd-padding-cell\"]:nth-child(2)")
    private WebElement fileNameOfAttachment;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement street1InputField;
    @FindBy(css = ".oxd-select-text.oxd-select-text--active")
    private WebElement countryField;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),\"Algeria\")]")
    private WebElement algeriaCountrySelection;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveContactDetails;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    private WebElement contactDetailsConfirmationMessage;
    @FindBy(xpath = "//label/input[@value='0']")
    private WebElement recordCheckBox;
    @FindBy(css = ".oxd-icon.bi-trash-fill.oxd-button-icon")
    private WebElement deleteSelectedRecordsBtn;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
            private WebElement confirmDeletionOfRecordBtn;

    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Actions actions = new Actions(getDriver());


    public void clickAddAttachmentButton() {
        waitUntilIsVisible(addAttachmentBtn);
        js.executeScript("arguments[0].scrollIntoView(true);", addAttachmentBtn);
        addAttachmentBtn.click();
    }

    public void addDocumentToContactDetails() {
        try {
            browseBtn.sendKeys(DocumentUtils.getPropertiesFile().getProperty("myDocPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leaveComment() {
        waitUntilIsClickable(commentAttachmentArea);
        commentAttachmentArea.sendKeys("Hi, just uploaded a document!");
    }

    public void clickSaveAttachmentButton() {
        saveAttachmentBtn.click();
    }

    public boolean verifyAttachmentIsAdded() {
        waitUntilIsVisible(fileNameOfAttachment);
        return fileNameOfAttachment.getText().equals("Hello.docx");
    }

    public void insertStreet1() {
        waitUntilIsVisible(street1InputField);
        try {
            street1InputField.click();
            street1InputField.sendKeys(Keys.COMMAND + "a");
            street1InputField.sendKeys(Keys.DELETE);
            street1InputField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("updatedStreet1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickCountryField() {
        countryField.click();
    }

    public void selectAlgeriaCountryOption() {
        waitUntilIsVisible(algeriaCountrySelection);
        algeriaCountrySelection.click();
    }

    public void clickSaveContactDetailsBtn() {
        waitUntilIsVisible(saveContactDetails);
        saveContactDetails.click();
    }

    public boolean verifyContactDetailsSuccessfullyUpdated() {
        waitUntilIsVisible(contactDetailsConfirmationMessage);
        return contactDetailsConfirmationMessage.getText().equals("Successfully Updated");
    }

    public void clickRecordCheckBox() {
        js.executeScript("arguments[0].scrollIntoView(true);", recordCheckBox);
//        actions.moveToElement(recordCheckBox).click().build().perform();
        js.executeScript("arguments[0].click();", recordCheckBox);

    }

    public void clickDeleteSelectedRecordsBtn() {
        deleteSelectedRecordsBtn.click();
    }

    public void acceptAlertOfDeletion() {
//        waitUntilAlertIsVisible();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        waitUntilIsVisible(confirmDeletionOfRecordBtn);
        confirmDeletionOfRecordBtn.click();
    }

    public boolean verifyContactRecordSuccessfullyDeleted() {
        return contactDetailsConfirmationMessage.getText().equals("Successfully Deleted");
    }

}
