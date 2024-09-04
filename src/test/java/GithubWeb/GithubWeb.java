package GithubWeb;

import Base.BaseClass;
import Pages.LoginPages;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GithubWeb extends BaseClass {

    @Test
    public void testOpenLoginPage() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.openUrl();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }

    @Test
    public void testInvalidLogin() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.openUrl();
        loginPage.login("invalidUsername", "invalidPassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    @Test
    public void testValidLogin() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.openUrl();
        loginPage.loginWithValidCredentials();
        boolean loginSuccess = loginPage.isLoginSuccessful();
        Assert.assertTrue(loginSuccess, "Valid login failed");
    }
}