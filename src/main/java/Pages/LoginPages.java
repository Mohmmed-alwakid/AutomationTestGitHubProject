package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static ObjectsPaths.LoginObjects.*;
import utils.ConfigReader;

import java.time.Duration;

public class LoginPages {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void openUrl() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void enterUsername(String username) {
        enterText(USERNAME_FIELD, username);
    }

    public void enterPassword(String password) {
        enterText(PASSWORD_FIELD, password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON)).click();
    }

    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.urlContains(ConfigReader.getProperty("base.url")));
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }

    public void loginWithInvalidCredentials() {
        login(ConfigReader.getProperty("invalid.username"), ConfigReader.getProperty("invalid.password"));
    }

    public void loginWithValidCredentials() {
        login(ConfigReader.getProperty("valid.username"), ConfigReader.getProperty("valid.password"));
    }

    public boolean isLoginSuccessful() {
        return isElementDisplayed(DASHBOARD_LOCATOR);
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}