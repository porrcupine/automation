package browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {
    public WebDriver driver;

    public abstract void configure();

    public abstract void close();

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

}
