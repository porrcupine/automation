package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public class RegPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public RegPage(WebDriverWrapper dr) {
        super(dr);
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
