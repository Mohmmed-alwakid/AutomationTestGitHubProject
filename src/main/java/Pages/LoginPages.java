package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        element.clear();
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        element.clear();
        element.sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON)).click();
    }

    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.urlContains("base.url"));
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }

    public void loginWithInvalidCredentials() {
        String username = ConfigReader.getProperty("invalid.username");
        String password = ConfigReader.getProperty("invalid.password");
        login(username, password);
    }

    public void loginWithValidCredentials() {
        String username = ConfigReader.getProperty("valid.username");
        String password = ConfigReader.getProperty("valid.password");
        login(username, password);
    }

    public boolean isLoginSuccessful() {
        try {
            // Wait for the Dashboard element to be visible
            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_LOCATOR));
            return dashboardElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}