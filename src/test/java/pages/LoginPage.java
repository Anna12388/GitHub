package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public static final By SIGN_IN_TITLE = By.xpath("h1[text() = 'Sign in to GitHub']");
    public static final By LOGIN_INPUT = By.id("login_field");
    public static final By PASS_INPUT = By.id("password");
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@value='Sign in']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@id = 'js-flash-container']/div/div/div");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage open(){
        driver.get(URL + "/login");
        return this;
    }
    public LoginPage inputLoginAndPass(String login, String pass){
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        driver.findElement(PASS_INPUT).sendKeys(pass);
        return this;
    }
    public HomePage clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
        return new HomePage(driver);
    }
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SIGN_IN_TITLE);
    }
}
