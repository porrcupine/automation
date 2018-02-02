package tests;

import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends Fixtures {

    @Test
    public void successfulLoginTest() {
        //showTestName("Successful login TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("t22333221@gmail.com");
        loginPage.enterPasswordData("teatatata1234");
        loginPage.clickLoginButton();
        Assert.assertTrue(customerPage.isLoginSuccessful());

//        if (customerPage.isLoginSuccessful()) {
//            System.out.println("Login successful!");
//        } else {
//            throw new IllegalStateException("Registration failed!");
//        }
    }

    @Test
    public void nonExistUserLoginTest() {
        showTestName("Non-exist user login TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("nonexist@gmail.com");
        loginPage.enterPasswordData("qweqrt");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginErrorMessage());
//        if (loginPage.isLoginErrorMessage()) {
//            loginPage.showErrorMessageText();
//        } else {
//            throw new IllegalStateException();
//        }
    }

    @Test
    public void emptyUserLoginTest() {
        showTestName("Empty user login TEST");
        browserFirefox.deleteAllCookies();
        browserFirefox.getTestUrl();
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("");
        loginPage.enterPasswordData("qweqrt");
        loginPage.clickLoginButton();
        if (loginPage.isAdviceReqEmailMessage()) {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void emptyUserPasswordTest() {
        showTestName("Empty user password TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("email@gmail.com");
        loginPage.enterPasswordData("");
        loginPage.clickLoginButton();
        if (loginPage.isAdviceReqPasswordMessage()) {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void emptyUserLoginAndPasswordTest() {
        showTestName("Empty user login and password TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("");
        loginPage.enterPasswordData("");
        loginPage.clickLoginButton();
        if ((loginPage.isAdviceReqPasswordMessage()) && (loginPage.isAdviceReqEmailMessage())) {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void incorrectUserLoginMaskTest() {
        showTestName("Incorrect mask of user login TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("t22333221 @gmail.com");
        loginPage.enterPasswordData("qwerty123");
        loginPage.clickLoginButton();
        if (!(customerPage.isLoginSuccessful())) {
            System.out.println("Test is successful"); //TODO show popup message
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void spacesInTheUserLoginAndPasswordTest() {
        showTestName("Spaces in the user login and password TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.pressSpaceInTheLoginData();
        loginPage.pressSpaceInThePasswordData();
        loginPage.clickLoginButton();
        if (!(customerPage.isLoginSuccessful())) {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void tabsInTheUserLoginAndPasswordTest() {
        showTestName("Tabs in the user login and password TEST");
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.pressTabInTheLoginData();
        loginPage.pressTabInThePasswordData();
        loginPage.clickLoginButton();
        if (!(customerPage.isLoginSuccessful())) {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }
}
