package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage {
    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/web/index.php/pim/contactDetails/empNumber/7']")
    private WebElement contactDetailsLink;

    public void clickContactDetailsLink() {
        waitUntilIsVisible(contactDetailsLink);
        contactDetailsLink.click();
    }
}
