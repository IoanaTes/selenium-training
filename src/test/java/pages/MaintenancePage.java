package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;
import java.util.List;

public class MaintenancePage extends BasePage {

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item']")
    private WebElement accessRecordsBtn;
    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input")
    private WebElement employeeNameInputSearch;
    @FindBy(xpath = "//div[@role='listbox']//span")
    private WebElement employeeNameSelection;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary:nth-child(2)")
    private WebElement searchBtn;
    @FindBy(css = ".oxd-label")
    private List<WebElement> employeeLabelList;

    public boolean verifyEmployeeIDIsDisplayed() {
        waitUntilListIsVisible(employeeLabelList);
        boolean myBool = false;
        for (WebElement element : employeeLabelList) {
            if (element.getText().contains("Employee Id")) {
                myBool = true;
                break;
            }
        }
        return myBool;
    }

    public void clickSearchBtn() {
        waitUntilIsClickable(searchBtn);
        searchBtn.click();
    }

    public void selectEmployeeName() {

        waitUntilIsVisible(employeeNameSelection);
        employeeNameSelection.click();
    }

    public void insertEmployeeName() {
        waitUntilIsClickable(employeeNameInputSearch);
        try {
            employeeNameInputSearch.sendKeys(DocumentUtils.getPropertiesFile().getProperty("secondInterviewer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickAccessRecordsBtn() {
        waitUntilIsVisible(accessRecordsBtn);
        accessRecordsBtn.click();
    }

    public void insertPassword() {
        waitUntilIsClickable(passwordField);
        try {
            passwordField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickConfirmBtn() {
        confirmBtn.click();
    }
}
