package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static ObjectsPaths.HomeObjects.*;  // Import the locators

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isDashboardVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_LOCATOR)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(PROFILE_DROPDOWN)).click();
    }

    public void clickNewRepository() {
        wait.until(ExpectedConditions.elementToBeClickable(NEW_REPOSITORY_BUTTON)).click();
    }

    public void searchForRepository(String repoName) {
        WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BAR));
        searchElement.clear();
        searchElement.sendKeys(repoName);
        searchElement.submit();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}