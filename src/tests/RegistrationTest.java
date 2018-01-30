package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CustomerPage;
import pages.HomePage;
import pages.RegPage;

public class RegistrationTest extends ATest {

    @BeforeClass
    public static void setUp() {
        browser = new Firefox();
        browser.configure();
        homePage = new HomePage(browser.driver);
        regPage = new RegPage(browser.driver);
        customerPage = new CustomerPage(browser.driver);
    }

    @Test
    public void newUserRegistrationTest() {
        System.out.println("\n\nnewUserRegistrationTest)");
        browser.getTestUrl();
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

    @AfterClass
    public static void tearDown() {
        browser.tearDown();
    }

}
