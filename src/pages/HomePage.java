package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class HomePage {
    private WebElementActions webElementActions;

    public HomePage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void clickLoginButton() {
        webElementActions.clickButton("home.page.login.button");
    }

    public void clickRegistrationButton() {
        webElementActions.clickButton("home.page.register.button");
    }

    public void showUsernameLogin() {
        System.out.println(webElementActions.getElementText("home.page.profilename.button"));
    }

    public void clickProfileButton() {
        webElementActions.clickButton("home.page.profile.button");
    }

}
