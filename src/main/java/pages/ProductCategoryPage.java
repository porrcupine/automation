package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebElementActions;

public class ProductCategoryPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    public ProductCategoryPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void clickProductCategoryLink() {
        webElementActions.clickLink("productcategoty.page.item.link");
    }
}
