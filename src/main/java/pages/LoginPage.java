package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

public class LoginPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String page = "http://magento-demo.lexiconn.com/customer/account/login/";


    public LoginPage(WebDriverWrapper dr) {
        super(dr, page);
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

    public void enterEmptyEmailSpecifiedPassword() {
        enterLoginEmailData("");
        enterPasswordData("qweqrt");
    }

    public void enterEmptyPasswordSpecifiedEmail() {
        enterLoginEmailData("email@gmail.com");
        enterPasswordData("");
    }

    public void enterEmptyEmailEmptyPassword() {
        enterLoginEmailData("");
        enterPasswordData("");
    }

    public void enterIncorrectEmailMaskSpecifiedPassword() {
        enterLoginEmailData("t22333221 @gmail.com");
        enterPasswordData("qwerty123");
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
