package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginBtn;

    public void setUsernameField() {
        waitUntilIsClickable(usernameField);
        usernameField.sendKeys("Admin");
    }

    public void setPasswordField() {
        passwordField.sendKeys("admin123");
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

}
