package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".oxd-userdropdown-name")
    private WebElement user;
    @FindBy(xpath = "//a[@href='/web/index.php/leave/viewLeaveModule']")
    private WebElement leaveLink;
    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
    private WebElement myInfoLink;
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminLink;
    @FindBy(xpath = "//a[@href=\"/web/index.php/pim/updatePassword\"]")
    private WebElement changePasswordBtn;

    public boolean isLoginSuccessful() {
        waitUntilIsClickable(user);
        return user.isDisplayed();
    }

    public void clickLeaveLink() {
        waitUntilIsVisible(leaveLink);
        leaveLink.click();
    }
    public void clickMyInfoLink() {
        waitUntilIsVisible(myInfoLink);
        myInfoLink.click();
    }
    public void clickAdminLink(){
        waitUntilIsVisible(adminLink);
        adminLink.click();
    }
    public void clickChangePasswordBtn(){
        waitUntilIsVisible(user);
        user.click();
        waitUntilIsVisible(changePasswordBtn);
        changePasswordBtn.click();
    }

}

