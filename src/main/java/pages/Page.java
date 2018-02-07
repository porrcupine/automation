package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public abstract class Page {
    static String testUrl = "http://magento-demo.lexiconn.com";
    static WebElementActions webElementActions;

    public static void goToBaseUrl(WebDriver driver) {
        driver.get(testUrl);
    }
}
