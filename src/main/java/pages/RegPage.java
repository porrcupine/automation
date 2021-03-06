package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

public class RegPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String page = "http://magento-demo.lexiconn.com/customer/account/create/";

    public RegPage(WebDriverWrapper dr) {
        super(dr, page);
    }

    public void enterName(String name) {
        webElementActions.input("reg.page.name.inputfield", name);
    }

    public void enterLastName(String surname) {
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

    public void enterNewUserDataAndClickRegister() {
        enterName("Fedor");
        enterLastName("Ivanov");
        enterEmail("t223332211@gmail.com");
        enterPassword("teatatata1234");
        enterPasswordConfirm("teatatata1234");
        clickRegButton();
    }

    public void clickRegButton() {
        webElementActions.submitButton("reg.page.register.button");
    }


}
