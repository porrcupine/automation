package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

public abstract class GlobalPageHeader extends Page{
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public GlobalPageHeader(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public GlobalPageHeader(WebDriverWrapper dr) {
        super(dr);
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

    public void clickMenuCategotyLink() {
        webElementActions.clickLink("globalmenu.page.menuheaderlink.link");
    }

}
