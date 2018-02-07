package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebElementActions;

public class HomePage extends GlobalPageHeader{
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HomePage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void clickLoginLink() {
        GlobalPageHeader.clickLogInLink();
    }

    public void clickRegistrationLink() {
        GlobalPageHeader.clickRegLink();
    }

    public void clickAccountLink() {
        GlobalPageHeader.clickAccountButton();
    }

    public void clickMenuCategoryLink() {
        GlobalPageHeader.clickMenuCategotyLink();
    }

    public void logIn() {
        clickAccountLink();
        clickLoginLink();
    }

    public void register() {
        clickAccountLink();
        clickRegistrationLink();
    }
}
