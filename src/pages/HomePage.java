package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class HomePage extends Page{

    public HomePage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
        globalPageHeader = new GlobalPageHeader(driver);
    }

    public void clickLoginLink() {
        globalPageHeader.clickLogInLink();
    }

    public void clickRegistrationLink() {
        globalPageHeader.clickRegLink();
    }

    public void clickAccountLink() {
        globalPageHeader.clickAccountButton();
    }

    public void clickMenuCategoryLink() {
        globalPageHeader.clickMenuCategotyLink();
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
