package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class RegPage {
    WebElementActions webElementActions;

    public RegPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void enterName(String name) {
        webElementActions.input("reg.page.name.inputfield", name);
    }

    public void lastName(String surname) {
        webElementActions.input("reg.page.lastname.inputfield", surname);
    }

    public void enterEmail(String email) {
        webElementActions.input("reg.page.email.inputfield", email);
    }

    public void enterPassword(String password) {
        webElementActions.input("reg.page.password.inputfield", password);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        webElementActions.input("reg.page.confirmpassword.inputfield", passwordConfirm);
    }

    public void clickRegButton() {
        webElementActions.submitButton("reg.page.register.button");
    }


}
