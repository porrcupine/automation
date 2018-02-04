package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class CustomerPage extends Page{

    public CustomerPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public boolean isRegistrationSuccessful() {
        if (webElementActions.isElementPresent("customer.page.sucessfulreg.text")) {
            return true;
        }
        return false;
    }

    public boolean isLoginSuccessful() {
        if (webElementActions.isElementPresent("customer.page.sucessfullogin.text")) {
            return true;
        }
        return false;
    }
}
