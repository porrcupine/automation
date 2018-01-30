package tests;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxTest extends ATest {
//    public void getUrl() {
//        driver.get(testUrl);
//    }

    //@BeforeClass
    @Override
    public void setUpTest() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla FirefoxQantum\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        testUrl = "http://magento-demo.lexiconn.com";
    }
    //@AfterClass
    @Override
    public void tearDownTest() {
        driver.quit();
    }

}
