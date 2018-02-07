package browser;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Firefox extends Browser {

    public void configure() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla FirefoxQantum\\firefox.exe");
        //System.setProperty("webdriver.gecko.browser", "C:\\Selenium\\geckodriver\\geckodriver.exe"); //JUnit
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void close() {
        driver.quit();
    }
}
