package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{
    @DataProvider(name="incorrectLoginTest")
    public Object[][] incorrectLoginTest(){
        return new Object[][]{
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
        };
    }
    @Test(dataProvider = "incorrectLoginTest")
    public void loginTestWithInvalidData(String login, String pass,String errorMessage){
        loginPage.open()
                .inputLoginAndPass(login,pass)
                .clickSignInButton();
        assertEquals(loginPage.getErrorMessage(), errorMessage, "Text doesn`t match");

    }
    @Test
    public void userShouldBeWithValidData(){
        loginPage.open()
                .inputLoginAndPass("Anna12388","Oscar202010")
                .clickSignInButton();
        boolean isHomePageOpen = homePage.isPageOpen();
        assertTrue(isHomePageOpen);
    }


}
