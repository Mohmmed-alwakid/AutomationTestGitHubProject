package GithubWeb;

import Base.BaseClass;
import ObjectsPaths.HomeObjects;
import Pages.LoginPages;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test
    public void testHomePageFunctionality() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.openUrl();
        loginPage.loginWithValidCredentials();

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isDashboardVisible(), "Dashboard is not visible after login");

        // Call the TERMS_LINKS locator from HomePage class
        WebElement termsLink = driver.findElement(HomeObjects.TERMS_LINKS);

        // Scroll to the terms link
        new Actions(driver)
                .scrollToElement(termsLink)
                .perform();
    }
}