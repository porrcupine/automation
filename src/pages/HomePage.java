package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class HomePage extends GlobalPageHeader{

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
