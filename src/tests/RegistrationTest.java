package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CustomerPage;
import pages.GlobalMenu;
import pages.RegPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private static WebDriver driver;
    private static String testUrl;
    private static CustomerPage customerPage;
    private static RegPage regPage;
    private static GlobalMenu globalMenu;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla FirefoxQantum\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        testUrl = "http://magento-demo.lexiconn.com/";
        globalMenu = new GlobalMenu(driver);
        customerPage = new CustomerPage(driver);
        regPage = new RegPage(driver);
    }

    @Test
    public void newUserRegistrationTest() {
        System.out.println("\n\nnewUserRegistrationTest)");
        driver.get(testUrl);
        globalMenu.clickAccountButton();
        globalMenu.clickRegLink();
        regPage.enterName("Fedor");
        regPage.lastName("Ivanov");
        regPage.enterEmail("t223332211@gmail.com");
        regPage.enterPassword("teatatata1234");
        regPage.enterPasswordConfirm("teatatata1234");
        regPage.clickRegButton();
        if (customerPage.isRegistrationSuccessful()) {
            System.out.println("Successeful registration!");
        } else {
            throw new IllegalStateException("Failed registration");
        }
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
