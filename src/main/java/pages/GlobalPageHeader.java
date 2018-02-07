package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebElementActions;

public abstract class GlobalPageHeader extends Page{
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static void clickAccountButton() {
        webElementActions.clickButton("globalmenu.page.account.button");
    }

    public static void clickRegLink() {
        webElementActions.clickLink("globalmenu.page.reg.link");
    }

    public static void clickLogInLink() {
        webElementActions.clickLink("globalmenu.page.login.link");
    }

    public static void clickMenuCategotyLink() {
        webElementActions.clickLink("globalmenu.page.menuheaderlink.link");
    }

}
