package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public static final By DASHBOARD_LINK = By.xpath("//a/span[normalize-space(text()) ='Dashboard']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DASHBOARD_LINK);
    }
}
