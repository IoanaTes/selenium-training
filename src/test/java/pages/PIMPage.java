package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;

public class PIMPage extends BasePage{

    public PIMPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//input[@type=\"password\"])[1]")
    private WebElement currentPassField;
    @FindBy(xpath = "(//input[@type=\"password\"])[2]")
    private WebElement newPassField;
    @FindBy(xpath = "(//input[@type=\"password\"])[3]")
    private WebElement confirmNewPassField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement passwordChangeConfirmationMessage;

    public void insertCurrentPassword(){
        try {
            waitUntilIsVisible(currentPassField);
            currentPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void insertNewPassword(){
        try {
            newPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void insertNewPasswordAgainToConfirm(){
        try {
            confirmNewPassField.sendKeys(DocumentUtils.getPropertiesFile().getProperty("anotherPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickSaveBtn(){
        saveBtn.click();
    }
    public boolean verifyPasswordIsChangedSuccessfully(){
        waitUntilIsVisible(passwordChangeConfirmationMessage);
        return passwordChangeConfirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

}
