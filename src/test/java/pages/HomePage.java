package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        WebElement nameDropdownBtn = driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
        WebElement restrainMenuBtn = driver.findElement(By.className("oxd-icon-button oxd-main-menu-button"));
        WebElement employeeDistribution = driver.findElement(By.id("LTXmSy8l"));
        WebElement element = driver.findElement(By.linkText(""));
        WebElement dashboardBtn = driver.findElement(By.xpath("//a[@href=\"/web/index.php/dashboard/index\"]"));

    }
}
