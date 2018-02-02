package tests;

import browser.Browser;
import browser.Firefox;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import pages.*;
import utils.UiMappingSingleton;

public class Fixtures {

    public static HomePage homePage;
    public static RegPage regPage;
    public static CustomerPage customerPage;
    public static LoginPage loginPage;
    public static ProductListPage productListPage;
    public static ProductCategoryPage productCategoryPage;
    public static Browser browserFirefox;


    @BeforeClass
    public static void setUp() {
        browserFirefox = new Firefox();
        browserFirefox.configure();

        homePage = new HomePage(browserFirefox.driver);
        regPage = new RegPage(browserFirefox.driver);
        customerPage = new CustomerPage(browserFirefox.driver);
        loginPage = new LoginPage(browserFirefox.driver);
        productListPage = new ProductListPage(browserFirefox.driver);
        productCategoryPage = new ProductCategoryPage(browserFirefox.driver);

        UiMappingSingleton.getInstance();
        System.out.println("DEBUG MESSAGE (before base test)");
    }

    @Before
    public void deleteCookiesAndGoToTestPage() {
        System.out.println("DEBUG MESSAGE (before test)");
        browserFirefox.deleteAllCookies();
        browserFirefox.getTestUrl();
    }

    @AfterClass
    public static void tearDown() {

        if (browserFirefox != null) {
            browserFirefox.tearDown();
        }
    }

    public void showTestName(String testName) {
        System.out.println("\n\n" + testName);
    }
}
