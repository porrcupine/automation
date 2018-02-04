package tests;

import browser.Browser;
import browser.Firefox;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.UiMappingSingleton;

public class Fixtures {

    public static HomePage homePage;
    public static RegPage regPage;
    public static CustomerPage customerPage;
    public static LoginPage loginPage;
    public static ProductListPage productListPage;
    public static ProductCategoryPage productCategoryPage;
    public static Browser browser;
    public static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        browser = new Firefox();
        browser.configure();
        driver = browser.driver;

        homePage = new HomePage(driver);
        regPage = new RegPage(driver);
        customerPage = new CustomerPage(driver);
        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
        productCategoryPage = new ProductCategoryPage(driver);

        UiMappingSingleton.getInstance();
        System.out.println("DEBUG MESSAGE (before base test)");
    }

    @BeforeMethod
    public void deleteCookiesAndGoToTestPage() {
        System.out.println("DEBUG MESSAGE (before test)");
        browser.deleteAllCookies();
        Page.goToBaseUrl(driver);
    }

    @AfterClass
    public static void tearDown() {
        if (browser != null) {
            browser.close();
        }
    }

    public void showTestName(String testName) {
        System.out.println("\n\n" + testName);
    }
}
