package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.Automation;
import utils.UiMappingSingleton;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

public abstract class Fixtures {
    public static WebDriverWrapper driver;
    public static Automation automation;
    // private static WebDriverFactory webDriverFactory;

    @BeforeSuite
    public static void setUpBeforeSuite() {
       driver = WebDriverFactory.initDriver();
        //driver = WebDriverFactory.getInstance();
        UiMappingSingleton.getInstance();
        System.out.println("**********Test suite started!**********");
    }

    @BeforeClass
    public void setUpBeforeClass() {
        automation = new Automation(driver);
    }

    @AfterMethod
    public void afterMethodTearDown(ITestResult testResult){
        if(!testResult.isSuccess()){
            automation.screenShotMaker.takeScreenShot(testResult.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            //driver.close(); //TODO Difference beetween close and quit
            driver.quit();
        }
    }

    public abstract void goToBasePage();
}
