package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriverWrapper driverWrapper;

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String INTERNET_EXPLORER = "ie";
    private static final String CHROME = "chrome";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");

    public static final String grid = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }

    public static WebDriverWrapper initDriver() {

        switch (browserName) {
            case FIREFOX:
                System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla FirefoxQantum\\firefox.exe");
                //System.setProperty("webdriver.gecko.browser", "C:\\Selenium\\geckodriver\\geckodriver.exe"); //JUnit
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\driver\\geckodriver.exe");
                driverWrapper = new WebDriverWrapper(new FirefoxDriver());
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driverWrapper = new WebDriverWrapper(new ChromeDriver(options));
                break;
            case INTERNET_EXPLORER:
                System.setProperty("webdriver.ie.driver", "src\\main\\resources\\driver\\IEDriverServer.exe");
                driverWrapper = new WebDriverWrapper(new InternetExplorerDriver());
                break;
            case PHANTOMJS:
//                File phantomjs = Phanbedder.unpack();
//                DesiredCapabilities caps = new DesiredCapabilities();
//                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
//                driverWrapper = new WebDriverWrapper( new PhantomJSDriver(caps));
                break;
            default:
                Assert.fail("invalid driver name");
        }


        driverWrapper.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driverWrapper.manage().deleteAllCookies();
        //  driverWrapper.manage().window().maximize();

        return driverWrapper;
    }

}
