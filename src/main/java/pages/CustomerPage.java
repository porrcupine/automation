package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public class CustomerPage extends GlobalPageHeader{
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String page = "http://magento-demo.lexiconn.com/customer/account/";

    public CustomerPage(WebDriverWrapper dr) {
        super(dr);
    }

    public boolean isRegistrationSuccessful() {
        return webElementActions.isElementPresent("customer.page.sucessfulreg.text");
    }

    public boolean isLoginSuccessful() {
        return webElementActions.isElementPresent("customer.page.sucessfullogin.text");
    }
}
