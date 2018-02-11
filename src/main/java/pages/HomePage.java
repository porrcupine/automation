package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

public class HomePage extends GlobalPageHeader{
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String page = "http://magento-demo.lexiconn.com/";

    public HomePage(WebDriverWrapper dr) {
        super(dr, page);
    }

    public void proceedToLogIn() {
        clickAccountButton();
        clickLogInLink();
    }

    public void proceedToRegister() {
        clickAccountButton();
        clickRegLink();
    }

    //
    //    }
    //        clickAccountButton();
    //    public void clickAccountLink() {
    //
    //    }
    //        clickRegLink();
    //    public void clickRegistrationLink() {
    //
    //    }
    //        clickLogInLink();
    //    public void clickLoginLink() {
}
