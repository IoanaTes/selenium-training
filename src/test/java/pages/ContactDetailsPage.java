package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends BasePage{

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--text")
    private WebElement addAttachmentBtn;
    @FindBy(xpath = "//div[@class='oxd-file-button']")
    private WebElement browseBtn;
    @FindBy(xpath = "//textarea")
    private WebElement commentAttachmentArea;
    @FindBy(xpath = "//div[@class='orangehrm-attachment']//button[@type='submit']")
    private WebElement saveAttachmentBtn;
    @FindBy(css = "[class=\"oxd-table-cell oxd-padding-cell\"]:nth-child(2)")
    private WebElement fileNameOfAttachment;


    public void clickAddAttachmentButton() {
        waitUntilIsVisible(addAttachmentBtn);
        addAttachmentBtn.click();
    }

    public void addDocumentToContactDetails() {
        waitUntilIsClickable(browseBtn);
        browseBtn.sendKeys("Users/iteslarasu/Desktop/Hello.docx");

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
}
