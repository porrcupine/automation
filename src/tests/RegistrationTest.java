package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.CustomerPage;
import pages.HomePage;
import pages.RegPage;

public class RegistrationTest extends FirefoxTest {
    private static ATest test = new FirefoxTest();
    private static HomePage homePage;
    private static RegPage regPage;
    private static CustomerPage customerPage;

    @BeforeClass
    public static void setUp() {
        test.setUpTest();
        homePage = new HomePage(test.driver);
        regPage = new RegPage(test.driver);
        customerPage = new CustomerPage(test.driver);
    }

    @org.junit.Test
    public void newUserRegistrationTest() {
        System.out.println("\n\nnewUserRegistrationTest)");
        test.getUrl();
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
        test.tearDownTest();
    }

}
