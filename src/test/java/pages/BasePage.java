package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

        public void waitUntilIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilIsInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitUntilAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void waitUntilElementIsSelected(By by){
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }
    public void waitUntilListIsVisible(List<WebElement> listOfElements){
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
    }
    public void waitUntilAlertIsVisible(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }



}
