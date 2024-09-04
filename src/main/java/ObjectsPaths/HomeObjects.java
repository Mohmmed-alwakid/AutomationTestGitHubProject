package ObjectsPaths;

import org.openqa.selenium.By;

public class HomeObjects {
    public static final By DASHBOARD_LOCATOR = By.xpath("//a[contains(@class,'AppHeader-context-item')]//span[contains(@class,'')][normalize-space()='Dashboard']");
    public static final By PROFILE_DROPDOWN = By.xpath("(//button[@id='dialog-show-dialog-51249c45-03da-4ce8-8813-88280d3320ab'])[1]");
    public static final By NEW_REPOSITORY_BUTTON = By.xpath("(//span[@class='Button-label'][normalize-space()='New'])[1]");
    public static final By SEARCH_BAR = By.xpath("(//div[contains(@class,'overflow-hidden')])[1]");
    public static final By TERMS_LINKS = By.xpath("//a[@class='Link--secondary Link'][normalize-space()='Terms']");

}