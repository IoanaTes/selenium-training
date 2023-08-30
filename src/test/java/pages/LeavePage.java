package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LeavePage extends BasePage {
    public LeavePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".oxd-select-text-input")
    private WebElement selectStatus;
    @FindBy(css = ".oxd-chip.oxd-chip--default.oxd-multiselect-chips-selected")
    private List<WebElement> statusSelectionList;
    @FindBy(xpath = "//div/span[contains(text(),'Rejected')]")
    private WebElement rejectedStatus;
    @FindBy(xpath = "(//button[@class=\"oxd-icon-button\"])[3]")
    private WebElement threeDotsRecordBtn;
    @FindBy(xpath = "(//li[@class=\"oxd-table-dropdown-item\"])[1]")
    private WebElement addCommentBtn;
    @FindBy(xpath = "//textarea")
    private WebElement commentTextArea;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement saveCommentBtn;
    @FindBy(xpath = "(//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text'])[1]")
    private WebElement commentAddedConfirmationMessage;
    @FindBy(xpath = "(//div[@role='cell'])[8]")
    private WebElement firstRecordComment;
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void selectRejectedStatus() {
        waitUntilIsVisible(selectStatus);
        selectStatus.click();
        waitUntilIsVisible(rejectedStatus);
        rejectedStatus.click();
    }

    public boolean findIfRejectedStatusIsSelected() {
        boolean myBool = false;
        for (WebElement element : statusSelectionList) {
            if (element.getText().equals("Rejected")) {
                myBool = true;
                break;
            }
        }
        return myBool;
    }

    public void clickThreeDotsRecordBtn() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js.executeScript("arguments[0].scrollIntoView(true);", threeDotsRecordBtn);
        threeDotsRecordBtn.click();
    }

    public void clickAddCommentBtn() {
        addCommentBtn.click();
    }

    public void introduceCommentForRecord() {
        waitUntilIsVisible(commentTextArea);
        try {
            commentTextArea.sendKeys(DocumentUtils.getPropertiesFile().getProperty("leaveRecordComment"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickSaveCommentBtn() {
        saveCommentBtn.click();
    }

    public boolean verifyConfirmationMessageIsDisplayed() {
        waitUntilIsVisible(commentAddedConfirmationMessage);
        return commentAddedConfirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

    public boolean verifyCommentIsAdded() throws IOException {
        waitUntilIsVisible(firstRecordComment);
        return firstRecordComment.getText().equalsIgnoreCase(DocumentUtils.getPropertiesFile().getProperty("leaveRecordComment"));
    }


}
