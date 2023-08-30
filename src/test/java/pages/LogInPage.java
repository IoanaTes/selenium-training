package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;

public class LogInPage extends BasePage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    private WebElement invalidUsernameAlert;


    public void setUsernameField(String username) {
        waitUntilIsClickable(usernameField);
        usernameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        waitUntilIsClickable(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {
        waitUntilIsVisible(loginBtn);
        waitUntilIsClickable(loginBtn);
        loginBtn.click();
    }

    public void setCredentials(String username) {
        try {
            if (username.equals("correct username")) {
                setUsernameField(DocumentUtils.getPropertiesFile().getProperty("username"));
                setPasswordField(DocumentUtils.getPropertiesFile().getProperty("password"));
            } else if (username.equals("incorrect username")) {
                setUsernameField(DocumentUtils.getPropertiesFile().getProperty("fakeusername"));
                setPasswordField(DocumentUtils.getPropertiesFile().getProperty("password"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean areCredentialsInvalid() {
        waitUntilIsVisible(invalidUsernameAlert);
        return invalidUsernameAlert.getText().equals("Invalid credentials");
    }

}
