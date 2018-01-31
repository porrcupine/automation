package tests;

import org.openqa.selenium.WebDriver;

public abstract class Browser {
    WebDriver driver;
    String testUrl;

    public abstract void configure();

    public abstract void tearDown();

    public void getTestUrl() {
        driver.get(testUrl);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

}
