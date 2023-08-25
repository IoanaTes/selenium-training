package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.CSS;
import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    WebElement nameDropdownBtn = driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
//    WebElement restrainMenuBtn = driver.findElement(By.className("oxd-icon-button oxd-main-menu-button"));
//    WebElement employeeDistribution = driver.findElement(By.id("LTXmSy8l"));
//    WebElement element = driver.findElement(By.linkText(""));
//    WebElement dashboardBtn = driver.findElement(By.xpath("//a[@href=\"/web/index.php/dashboard/index\"]"));
//    WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));


    @FindBy(css = ".oxd-userdropdown-name")
    private WebElement user;
    @FindBy(xpath = "//a[@href='/web/index.php/leave/viewLeaveModule']")
    private WebElement leaveLink;
    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
    private WebElement myInfoLink;
    @FindBy(css = ".oxd-select-text-input")
    private WebElement selectStatus;
    @FindBy(css = ".oxd-chip.oxd-chip--default.oxd-multiselect-chips-selected")
    private List<WebElement> statusSelectionList;
    @FindBy(xpath = "//div/span[contains(text(),'Rejected')]")
    private WebElement rejectedStatus;






    public boolean isLoginSuccessful() {
        waitUntilIsClickable(user);
        return user.isDisplayed();
    }

    public void clickLeaveLink() {
        waitUntilIsVisible(leaveLink);
        leaveLink.click();
    }
    public void selectRejectedStatus() {
        waitUntilIsVisible(selectStatus);
        selectStatus.click();
        waitUntilIsVisible(rejectedStatus);
        rejectedStatus.click();

    }
    public boolean findIfRejectedStatusIsSelected(){
        boolean myBool = false;
        for(WebElement element : statusSelectionList){
            if(element.getText().equals("Rejected")) {
                myBool = true;
                break;
            }
        }
        return myBool;
    }
    public void clickMyInfoLink() {
        waitUntilIsVisible(myInfoLink);
        myInfoLink.click();
    }

}

