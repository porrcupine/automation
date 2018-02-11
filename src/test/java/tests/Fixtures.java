package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.Automation;
import utils.UiMappingSingleton;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

public class Fixtures {
    public static WebDriverWrapper driver;
    public static Automation automation;
   // private static WebDriverFactory webDriverFactory;

    @BeforeSuite
    public static void setUp() {


        driver = WebDriverFactory.initDriver();
        UiMappingSingleton.getInstance();
        System.out.println("DEBUG MESSAGE (Before Sute test)");
    }

    @BeforeMethod
    public void deleteCookiesAndGoToTestPage() {
        System.out.println("DEBUG MESSAGE (Before Test)");
        automation = new Automation(driver);
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
