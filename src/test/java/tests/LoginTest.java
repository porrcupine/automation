package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Fixtures {

    @Test
    public void validCredentialsLoginTest() {
        homePage.logIn();
        loginPage.enterValidCredentials();
        loginPage.clickLoginButton();
        Assert.assertTrue(customerPage.isLoginSuccessful(), "Login with the valid credentials failed!");
    }

    @Test
    public void nonExistUserLoginTest() {
        homePage.logIn();
        loginPage.enterInvalidCredentials();
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isShowLoginErrorMessage(), "Login with the invalid credentials failed!");
    }

    @Test
    public void emptyUserLoginTest() {
        homePage.logIn();
        loginPage.enterLoginEmailData("");
        loginPage.enterPasswordData("qweqrt");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
    }

    @Test
    public void emptyUserPasswordTest() {
        homePage.logIn();
        loginPage.enterLoginEmailData("email@gmail.com");
        loginPage.enterPasswordData("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void emptyUserLoginAndPasswordTest() {
        homePage.logIn();
        loginPage.enterLoginEmailData("");
        loginPage.enterPasswordData("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
        Assert.assertTrue(loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void incorrectUserLoginMaskTest() {
        homePage.logIn();
        loginPage.enterLoginEmailData("t22333221 @gmail.com");
        loginPage.enterPasswordData("qwerty123");
        loginPage.clickLoginButton();
        Assert.assertFalse(customerPage.isLoginSuccessful(), "Incorrect mask test failed"); //TODO show popup message
    }

    @Test
    public void spacesInTheUserLoginAndPasswordTest() {
        homePage.logIn();
        loginPage.pressSpaceInTheLoginData();
        loginPage.pressSpaceInThePasswordData();
        loginPage.clickLoginButton();
        Assert.assertFalse(customerPage.isLoginSuccessful(),"Spaces in login & password test failed");
    }

    @Test
    public void tabsInTheUserLoginAndPasswordTest() {
        homePage.logIn();
        loginPage.pressTabInTheLoginData();
        loginPage.pressTabInThePasswordData();
        loginPage.clickLoginButton();
        Assert.assertFalse(customerPage.isLoginSuccessful(),"Tabs in login & password test failed");
    }
}
