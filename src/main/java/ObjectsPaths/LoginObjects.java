package ObjectsPaths;

import org.openqa.selenium.By;

public class LoginObjects {
    public static final By USERNAME_FIELD = By.xpath("/html[1]/body[1]/div[1]/div[3]/main[1]/div[1]/div[4]/form[1]/input[3]");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By SIGN_IN_BUTTON = By.name("commit");
    public static final By ERROR_MESSAGE = By.className("flash-error");
    public static final By DASHBOARD_LOCATOR = By.xpath("//a[contains(@class,'AppHeader-context-item')]//span[contains(@class,'')][normalize-space()='Dashboard']");

}