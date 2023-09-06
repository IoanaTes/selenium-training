package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait fluentWait;


    public void fluentWait(Function condition) {
        fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        fluentWait.until(condition);
    }

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

    public void waitUntilIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilListIsVisible(List<WebElement> listOfElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }


}
