package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class HomePage extends Page{

    public HomePage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
        globalPageHeader = new GlobalPageHeader(driver);
    }

    public void clickLoginButton() {
        globalPageHeader.clickLogInLink();
    }

    public void clickRegistrationButton() {
        globalPageHeader.clickRegLink();
    }

    public void clickAccountButton() {
        globalPageHeader.clickAccountButton();
    }

    public void clickMenuCategoryLink() {
        globalPageHeader.clickMenuCategotyLink();
    }
}
