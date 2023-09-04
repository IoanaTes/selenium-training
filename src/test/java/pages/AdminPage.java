package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DocumentUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Configuration\")]")
    private WebElement configurationDropdownBtn;
    @FindBy(xpath = "//a[contains(text(),\"Language Packages\")]")
    private WebElement languagePackagesSelection;
    @FindBy(xpath = "//div[@class=\"orangehrm-container\"]//div[@class=\"oxd-table-card\"]")
    private List<WebElement> languageList;
    @FindBy(xpath = "(//button[@type='button'])[20]")
    private WebElement spanishTranslateBtn;
    @FindBy(xpath = "//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
    private WebElement addNewLanguageBtn;
    @FindBy(xpath = "//div[@class=\"oxd-select-text-input\"]")
    private WebElement languageSelectorDropdown;
    @FindBy(xpath = "//div[@role=\"option\"][2]")
    private WebElement newLanguageSelection;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement confirmationMessage;
    @FindBy(css = ".orangehrm-container")
    private WebElement languageContainer;
    @FindBy(xpath = "(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]") ////span[contains(text(),"Job")]
    private WebElement jobDropdownBtn;
    @FindBy(xpath = "//a[contains(text(),\"Job Titles\")]")
    private WebElement jobTitleSelection;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addNewJobBtn;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement jobTitleInput;
    @FindBy(xpath = "//textarea[@placeholder=\"Type description here\"]")
    private WebElement jobDescriptionInput;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement jobSpecificationBtn;
    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell']//div")
    private List<WebElement> jobRecords;


    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void clickConfigurationDropdownBtn() {
        waitUntilIsVisible(configurationDropdownBtn);
        configurationDropdownBtn.click();
    }

    public void selectLanguagePackages() {
        waitUntilIsVisible(languagePackagesSelection);
        languagePackagesSelection.click();

    }

    public void clickSpanishTranslateBtn() {
        waitUntilListIsVisible(languageList);
        for (int i = 0; i < languageList.size(); i++) {
            if (languageList.get(i).findElements(By.xpath("//div[@role='cell']//div[@data-v-6c07a142='']")).get(i).getText().contains("Spanish - Español")) {
                languageList.get(i).findElements(By.xpath("//div[@role='cell']//div[contains(@class,\"actions\")]//button[1]")).get(i).click();
                break;
            }
        }
    }

    public boolean verifyRedirectToLanguageCustomizationPage() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return getDriver().getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/admin/languageCustomization");
    }

    public void clickAddNewLanguageBtn() {
        waitUntilIsVisible(addNewLanguageBtn);
        addNewLanguageBtn.click();
    }

    public void clickLanguageSelector() {
        waitUntilIsVisible(languageSelectorDropdown);
        languageSelectorDropdown.click();
    }

    public void selectANewLanguage() {
        newLanguageSelection.click();
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }

    public boolean verifyConfirmationMessage() {
        waitUntilIsVisible(confirmationMessage);
        return confirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

    public void clickJobDropdownBtn() {
        waitUntilIsVisible(jobDropdownBtn);
        jobDropdownBtn.click();
    }

    public void selectJobTitle() {
        waitUntilIsVisible(jobTitleSelection);
        jobTitleSelection.click();
    }

    public void clickAddJobBtn() {
        waitUntilIsVisible(addNewJobBtn);
        addNewJobBtn.click();
    }

    public void addJobTitle() {
        waitUntilIsVisible(jobTitleInput);
        try {
            jobTitleInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("jobTitle") + Math.random());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addJobDescription() {
        try {
            jobDescriptionInput.sendKeys(DocumentUtils.getPropertiesFile().getProperty("jobDescription"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addJobSpecificationAttachment() {
        try {
            jobSpecificationBtn.sendKeys(DocumentUtils.getPropertiesFile().getProperty("myDocPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
