package tests;

import browser.Firefox;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CustomerPage;
import pages.HomePage;
import pages.RegPage;

public class RegistrationTest extends BaseTest {

    public static void setUp() {
        browserFirefox = new Firefox();
        browserFirefox.configure();
        homePage = new HomePage(browserFirefox.driver);
        regPage = new RegPage(browserFirefox.driver);
        customerPage = new CustomerPage(browserFirefox.driver);
    }

    @Test
    public void newUserRegistrationTest() {
        showTestName("New user registration TEST");
        browserFirefox.getTestUrl();
        homePage.clickAccountButton();
        homePage.clickRegistrationButton();
        regPage.enterName("Fedor");
        regPage.lastName("Ivanov");
        regPage.enterEmail("t223332211@gmail.com");
        regPage.enterPassword("teatatata1234");
        regPage.enterPasswordConfirm("teatatata1234");
        regPage.clickRegButton();
        if (customerPage.isRegistrationSuccessful()){
            System.out.println("Successeful registration!");
        } else{
            throw new IllegalStateException("Failed registration");
        }
    }


}
