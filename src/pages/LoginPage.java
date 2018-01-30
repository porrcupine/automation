package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class LoginPage extends Page {
   // private WebElementActions webElementActions;
    public LoginPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void enterLoginEmailData(String login) {
        webElementActions.input("login.page.username.inputfield", login);
    }

    public  void  enterPasswordData(String password) {
        webElementActions.input("login.page.password.inputfield", password);
    }

    public void clickLoginButton() {
        webElementActions.clickButton("login.page.signin.button");
    }

    public boolean isLoginErrorMessage() {
        if (webElementActions.isElementPresent("login.page.error.message")) {
            return true;
        }
        return false;
    }

    public void showErrorMessageText() {
        System.out.println(webElementActions.getElementText("login.page.error.text"));
    }
}
