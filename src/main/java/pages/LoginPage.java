package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebElementActions;

public class LoginPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void enterLoginEmailData(String login) {
        webElementActions.input("login.page.username.inputfield", login);
    }

    public void enterPasswordData(String password) {
        webElementActions.input("login.page.password.inputfield", password);
    }

    public void enterValidCredentials() {
        enterLoginEmailData(PropertyLoader.loadProperty("credentials.valid.login"));
        enterPasswordData(PropertyLoader.loadProperty("credentials.valid.password"));
    }

    public void enterInvalidCredentials() {
        enterLoginEmailData(PropertyLoader.loadProperty("credentials.invalid.login"));
        enterPasswordData(PropertyLoader.loadProperty("credentials.invalid.password"));
    }


    public void clickLoginButton() {
        webElementActions.clickButton("login.page.signin.button");
    }

    public void showErrorMessageText() {
        System.out.println(webElementActions.getElementText("login.page.error.text"));
    }

    public void pressSpaceInTheLoginData() {
        webElementActions.pressSpaceKey("login.page.username.inputfield");
    }

    public void pressSpaceInThePasswordData() {
        webElementActions.pressSpaceKey("login.page.password.inputfield");
    }

    public void pressTabInThePasswordData() {
        webElementActions.pressTABkey("login.page.password.inputfield");
    }

    public void pressTabInTheLoginData() {
        webElementActions.pressTABkey("login.page.username.inputfield");
    }

    public boolean isShowLoginErrorMessage() {
        return webElementActions.isElementPresent("login.page.error.message");
    }

    public boolean isAdviceReqEmailMessage() {
        if (webElementActions.isElementPresent("login.page.advicereqemail.text")) {
            System.out.println(webElementActions.getElementText("login.page.advicereqemail.text"));
            return true;
        }
        return false;
    }

    public boolean isAdviceReqPasswordMessage() {
        if (webElementActions.isElementPresent("login.page.advicereqpass.text")) {
            System.out.println(webElementActions.getElementText("login.page.advicereqpass.text"));
            return true;
        }
        return false;
    }

}
