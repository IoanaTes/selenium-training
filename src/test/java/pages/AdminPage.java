package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Configuration\")]")
    private WebElement configurationDropdownBtn;
    @FindBy(xpath = "//a[contains(text(),\"Language Packages\")]")
    private WebElement languagePackagesSelection;
    @FindBy(xpath = "(//button[@type='button'])[20]")
    private WebElement spanishTranslateBtn;
    @FindBy(xpath = "//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
    private WebElement addNewLanguageBtn;
    @FindBy(xpath = "//div[@class=\"oxd-select-text-input\"]")
    private WebElement languageSelectorDropdown;
    @FindBy(xpath = "//span[contains(text(),\"Colognian\")]")
    private WebElement colognianLanguageSelection;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveLanguageSelectionBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    private WebElement languageSelectionConfirmationMessage;

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
        waitUntilIsVisible(spanishTranslateBtn);
        spanishTranslateBtn.click();
    }

    public boolean verifyRedirectToLanguageCustomizationPage() {
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

    public void selectColognianAsANewLanguage() {
        waitUntilIsClickable(colognianLanguageSelection);
        colognianLanguageSelection.click();
    }

    public void clickSaveLanguageSelectionBtn() {
        saveLanguageSelectionBtn.click();
    }

    public boolean verifyLanguageIsSuccessfullyAdded() {
        waitUntilIsVisible(languageSelectionConfirmationMessage);
        return languageSelectionConfirmationMessage.getText().equalsIgnoreCase("Successfully Saved");
    }

}
