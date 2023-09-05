package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    private WebElement statusSelect;
    @FindBy(css = ".oxd-chip.oxd-chip--default.oxd-multiselect-chips-selected")
    private List<WebElement> statusSelectionList;
    @FindBy(xpath = "//div/span[contains(text(),'Rejected')]")
    private WebElement rejectedStatus;
    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border']//button[@class='oxd-icon-button']")
    private List<WebElement> threeDotsRecordListBtn;
    @FindBy(xpath = "(//li[@class='oxd-table-dropdown-item'])[1]")
    private WebElement addCommentBtn;
    @FindBy(xpath = "//textarea")
    private WebElement commentTextArea;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement saveCommentBtn;
    @FindBy(xpath = "(//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text'])[1]")
    private WebElement commentAddedConfirmationMessage;
    @FindBy(xpath = "(//div[@role='cell'])[8]")
    private WebElement firstRecordComment;
    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[1]")
    private WebElement calendarBox;
    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[2]")
    private WebElement secondCalendarBox;
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement leaveTypeSelect;
    @FindBy(xpath = "//div[@class='oxd-select-option']")
    private List<WebElement> usVacationLeaveType;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement searchLeaveRecordsBtn;
    @FindBy(xpath = "//div[contains(text(),'US - Vacation')]")
    private WebElement usVacationRecord;
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")
    private WebElement employeeNameInput;
    @FindBy(xpath = "//div[@role='option']/span")
    private WebElement selectEmployeeName;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement confirmationMessage;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--ghost")
    private WebElement resetBtn;
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void selectRejectedStatus() {
        waitUntilIsVisible(statusSelect);
        statusSelect.click();
        waitUntilIsVisible(rejectedStatus);
        rejectedStatus.click();
    }

    public boolean findIfStatusIsSelected(String status) {
        boolean myBool = false;
        for (WebElement element : statusSelectionList) {
            if (element.getText().equals(status)) {
                myBool = true;
                break;
            }
        }
        return myBool;
    }

    public void clickThreeDotsRecordBtn() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js.executeScript("arguments[0].scrollIntoView(true);", threeDotsRecordListBtn.get(0));
        js.executeScript("arguments[0].click();", threeDotsRecordListBtn.get(0));
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

    public void completeCalendarPeriodForLeave(String fromCalendar, String toCalendar) {
        waitUntilIsVisible(calendarBox);
        calendarBox.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        calendarBox.sendKeys(Keys.DELETE);
        calendarBox.sendKeys(fromCalendar);
        secondCalendarBox.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        secondCalendarBox.sendKeys(Keys.DELETE);
        secondCalendarBox.sendKeys(toCalendar);
    }

    public void selectVacationLeaveType(String leaveType) {
        waitUntilIsVisible(leaveTypeSelect);
        leaveTypeSelect.click();
        for (WebElement element : usVacationLeaveType)
            if (element.getText().equalsIgnoreCase(leaveType)) {
                element.click();
                break;
            }

    }

    public void clickSearchRecordsBtn() {
        js.executeScript("arguments[0].click();", searchLeaveRecordsBtn);

    }

    public boolean verifyRecordsAreFound() {
        waitUntilIsVisible(usVacationRecord);
        return usVacationRecord.isDisplayed();
    }

    public void insertEmployeeName(String employeeName) {
        employeeNameInput.sendKeys(employeeName);
        waitUntilIsVisible(selectEmployeeName);
        selectEmployeeName.click();
    }

    public boolean verifyNoRecordsAreFound() {
        waitUntilIsVisible(confirmationMessage);
        return confirmationMessage.getText().equals("No Records Found");
    }
    public void clickResetBtn(){
        waitUntilIsVisible(resetBtn);
        resetBtn.click();
    }
    public boolean verifyResetIsSuccessful(){
        waitUntilIsVisible(employeeNameInput);
        return employeeNameInput.getAttribute("placeholder").equals("Type for hints...");
    }

}
