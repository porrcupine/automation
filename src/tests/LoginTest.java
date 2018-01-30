package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CustomerPage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends ATest {

    @BeforeClass
    public static void setUp() {
        browser = new Firefox();
        browser.configure();
        homePage = new HomePage(browser.driver);
        customerPage = new CustomerPage(browser.driver);
        loginPage = new LoginPage(browser.driver);
    }

    @Test
    public void successfulLoginTest() {
        showTestName("Successful login test");
        browser.deleteAllCookies();
        browser.getTestUrl();
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("t22333221@gmail.com");
        loginPage.enterPasswordData("teatatata1234");
        loginPage.clickLoginButton();
        if (customerPage.isLoginSuccessful()) {
            System.out.println("Login successful!");
        } else {
            throw new IllegalStateException("Registration failed!");
        }
    }

    @Test
    public void nonExistUserLoginTest() {
        showTestName("Non-exist user login test");
        browser.deleteAllCookies();
        browser.getTestUrl();
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("nonexist@gmail.com");
        loginPage.enterPasswordData("qweqrt");
        loginPage.clickLoginButton();
        if (loginPage.isLoginErrorMessage()) {
            loginPage.showErrorMessageText();
        } else {
            throw new IllegalStateException();
        }
    }

    @Test
    public void emptyUserLoginTest() {
        showTestName("Empty user login test");
        browser.deleteAllCookies();
        browser.getTestUrl();
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
        showTestName("Empty user password test");
        browser.deleteAllCookies();
        browser.getTestUrl();
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
        showTestName("Empty user login and password test");
        browser.deleteAllCookies();
        browser.getTestUrl();
        homePage.clickAccountButton();
        homePage.clickLoginButton();
        loginPage.enterLoginEmailData("");
        loginPage.enterPasswordData("");
        loginPage.clickLoginButton();
        if ((loginPage.isAdviceReqPasswordMessage()) && (loginPage.isAdviceReqEmailMessage()))  {
            System.out.println("Test is successful");
        } else {
            throw new IllegalStateException();
        }
    }

    @AfterClass
    public static void tearDown() {
        browser.tearDown();
    }
}
