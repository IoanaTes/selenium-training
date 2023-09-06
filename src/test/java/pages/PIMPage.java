package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;
import java.time.Duration;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement currentPassField;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement newPassField;
    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement confirmNewPassField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addEmployeeBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement employeePicture;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameInput;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
    private WebElement employeeID;
    @FindBy(css = ".oxd-switch-wrapper")
    private WebElement loginDetailsSwitch;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement usernameField;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordField;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordField;
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement saveEmployeeBtn;

    public boolean verifyEmployeeIsAdded() {
        waitUntilIsVisible(confirmationMessage);
        return confirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

    public void clickSaveEmployeeBtn() {
        saveEmployeeBtn.click();
    }

    public void insertUsernameField() {
        waitUntilIsVisible(usernameField);
        try {
            usernameField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("fakeUsername") + Math.random());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertPasswordField() {
        waitUntilIsVisible(passwordField);
        try {
            passwordField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertConfirmationPasswordField() {
        waitUntilIsVisible(confirmPasswordField);
        try {
            confirmPasswordField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void clickLoginDetailsSwitch() {
        loginDetailsSwitch.click();
    }

    public void insertEmployeeID() {
        employeeID.clear();
        try {
            employeeID.sendKeys(DocumentUtils.getPropertiesFile().getProperty("employeeID"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertEmployeeFullName() {
        waitUntilIsVisible(firstNameInput);
        try {
            firstNameInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("firstName"));
            middleNameInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("middleName"));
            lastNameInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("lastName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEmployeePicture() {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            employeePicture.sendKeys(DocumentUtils.getPropertiesFile().getProperty("profilePicturePath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickAddEmployeeBtn() {
        waitUntilIsVisible(addEmployeeBtn);
        addEmployeeBtn.click();
    }

    public void insertCurrentPassword() {
        try {
            waitUntilIsVisible(currentPassField);
            currentPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertNewPassword() {
        try {
            newPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertNewPasswordAgainToConfirm() {
        try {
            confirmNewPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }

    public boolean verifyPasswordIsChangedSuccessfully() {
        waitUntilIsVisible(confirmationMessage);
        return confirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

}
