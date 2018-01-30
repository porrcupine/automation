package tests;

import org.openqa.selenium.WebDriver;
import pages.Page;

public abstract class ATest {
    WebDriver driver;
    String testUrl;
    Page page;

    public void getUrl() {
        driver.get(testUrl);
    }

    public abstract void setUpTest();

    public abstract void tearDownTest();
}
