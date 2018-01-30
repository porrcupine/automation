package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class GlobalMenu {
    WebElementActions webElementActions;

    public GlobalMenu(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void clickAccountButton() {
        webElementActions.clickButton("globalmenu.page.account.button");
    }

    public void clickRegLink() {
        webElementActions.clickLink("globalmenu.page.reg.link");
    }

    public void clickLogInLink() {
        webElementActions.clickLink("globalmenu.page.login.link");
    }

}
