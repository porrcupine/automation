package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Fixtures {

    @BeforeMethod
    @Override
    public void goToBasePage() {
        automation.loginPage.openPage();
    }

    @Test
    public void validCredentialsLoginTest() {
        automation.loginPage.enterValidCredentials();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.customerPage.isLoginSuccessful(), "Login with the valid credentials failed!");
    }

    @Test
    public void nonExistUserLoginTest() {
        automation.loginPage.enterInvalidCredentials();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isShowLoginErrorMessage(), "Login with the invalid credentials failed!");
    }

    @Test
    public void emptyUserLoginTest() {
        automation.loginPage.enterEmptyEmailSpecifiedPassword();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
    }

    @Test
    public void emptyUserPasswordTest() {
        automation.loginPage.enterEmptyPasswordSpecifiedEmail();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void emptyUserLoginAndPasswordTest() {
        automation.loginPage.enterEmptyEmailEmptyPassword();
        automation.loginPage.clickLoginButton();
        Assert.assertTrue(automation.loginPage.isAdviceReqEmailMessage(), "No error message with empty email input");
        Assert.assertTrue(automation.loginPage.isAdviceReqPasswordMessage(), "No error message with empty pass input");
    }

    @Test
    public void incorrectUserLoginMaskTest() {
        automation.loginPage.enterIncorrectEmailMaskSpecifiedPassword();
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Incorrect mask test failed"); //TODO show popup message
    }

    @Test
    public void spacesInTheUserLoginAndPasswordTest() {
        automation.loginPage.pressSpaceInTheLoginData();
        automation.loginPage.pressSpaceInThePasswordData();
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Spaces in login & password test failed");
    }

    @Test
    public void tabsInTheUserLoginAndPasswordTest() {
        automation.loginPage.pressTabInTheLoginData();
        automation.loginPage.pressTabInThePasswordData();
        automation.loginPage.clickLoginButton();
        Assert.assertFalse(automation.customerPage.isLoginSuccessful(), "Tabs in login & password test failed");
    }
}
