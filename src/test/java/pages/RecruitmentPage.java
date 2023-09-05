package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;
import java.util.List;


public class RecruitmentPage extends BasePage {
    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[4]")
    private WebElement statusSelection;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']")
    private List<WebElement> candidatesFilterList;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement searchBtn;
    @FindBy(css = ".oxd-icon.bi-eye-fill")
    private List<WebElement> viewIcons;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--success")
    private WebElement scheduleInterviewBtn;
    @FindBy(xpath = "(//div[@class='oxd-form-row']//input)[5]")
    private WebElement interviewTitleInput;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement interviewersInput;
    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span")
    private WebElement interviewerSelect;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']")
    private WebElement addAnotherInterviewerInput;
    @FindBy(xpath = "(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[2]")
    private WebElement anotherInterviewerInput;
    @FindBy(xpath = "//input[@placeholder='dd-mm-yyyy']")
    private WebElement dateInput;
    @FindBy(xpath = "//input[@placeholder='hh:mm']")
    private WebElement timeInput;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement saveInterviewBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']//ul/li[2]")
    private WebElement vacanciesBtn;
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    private WebElement jobTitleInput;
    @FindBy(xpath = "(//div[@role='listbox'])/div[2]")
    private WebElement accountAssistantSelection;
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
    private WebElement recordsFoundText;

    public String verifyRecordsAreFoundForThisVacancy(){
        return recordsFoundText.getText();
    }

    public void selectAccountAssistantJob(){
        waitUntilIsVisible(accountAssistantSelection);
        accountAssistantSelection.click();
    }

    public void clickJobTitleInput(){
        waitUntilIsVisible(jobTitleInput);
        jobTitleInput.click();
    }

    public void clickVacanciesBtn(){
        waitUntilIsVisible(vacanciesBtn);
        vacanciesBtn.click();
    }

    public void selectShortListedStatus() {
        waitUntilListIsVisible(candidatesFilterList);
        for (WebElement element : candidatesFilterList) {
            if (element.findElement(By.cssSelector("label.oxd-label")).getText().contains("Status")) {
                element.findElement(By.cssSelector(".oxd-select-text--after")).click();
                element.findElement(By.xpath("//span[contains(text(),'Shortlisted')]")).click();
                break;
            }
        }
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }
    public void clickViewBtn(){
        waitUntilListIsVisible(viewIcons);
        viewIcons.get(0).click();
    }
    public void clickScheduleInterviewBtn(){
        waitUntilIsVisible(scheduleInterviewBtn);
        scheduleInterviewBtn.click();
    }
    public void insertTitle(){
        waitUntilIsVisible(interviewTitleInput);
        try {
            interviewTitleInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("interviewTitle"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addTwoInterviewers(){
        try {
            interviewersInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("firstInterviewer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitUntilIsVisible(interviewerSelect);
        interviewerSelect.click();
        addAnotherInterviewerInput.click();
        try {
            anotherInterviewerInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("secondInterviewer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitUntilIsVisible(interviewerSelect);
        interviewerSelect.click();
    }
    public void insertDateForInterview(){
        waitUntilIsVisible(dateInput);
        try {
            dateInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("interviewDate"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void insertTimeForInterview(){
        try {
            timeInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("interviewTime"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickSaveInterviewBtn(){
        saveInterviewBtn.click();
    }
    public boolean verifyInterviewIsAdded() {
        waitUntilIsVisible(confirmationMessage);
        return confirmationMessage.getText().equals("Successfully Updated");
    }

}
