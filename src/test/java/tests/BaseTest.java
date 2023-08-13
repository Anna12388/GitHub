package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.compress.archivers.zip.Zip64Mode.Always;

public abstract class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);


    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

