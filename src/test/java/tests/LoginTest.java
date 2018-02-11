package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Fixtures {

    @BeforeMethod
    public void goToBasePage() {
        automation.homePage.openPage();
    }

    @Test
    public void validCredentialsLoginTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterValidCredentials();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.customerPage.isLoginSuccessful(), "Login with the valid credentials failed!");
    }

    @Test
    public void nonExistUserLoginTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterInvalidCredentials();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isShowLoginErrorMessage(), "Login with the invalid credentials failed!");
    }

    @Test
    public void emptyUserLoginTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterLoginEmailData("");
        automation.loginPage.enterPasswordData("qweqrt");
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
    }

    @Test
    public void emptyUserPasswordTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterLoginEmailData("email@gmail.com");
        automation.loginPage.enterPasswordData("");
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void emptyUserLoginAndPasswordTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterLoginEmailData("");
        automation.loginPage.enterPasswordData("");
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
        Assert.assertTrue(automation.loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void incorrectUserLoginMaskTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.enterLoginEmailData("t22333221 @gmail.com");
        automation.loginPage.enterPasswordData("qwerty123");
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Incorrect mask test failed"); //TODO show popup message
    }

    @Test
    public void spacesInTheUserLoginAndPasswordTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.pressSpaceInTheLoginData();
        automation.loginPage.pressSpaceInThePasswordData();
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Spaces in login & password test failed");
    }

    @Test
    public void tabsInTheUserLoginAndPasswordTest() {
        automation.homePage.proceedToLogIn();
        automation.loginPage.pressTabInTheLoginData();
        automation.loginPage.pressTabInThePasswordData();
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Tabs in login & password test failed");
    }
}
