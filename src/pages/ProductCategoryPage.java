package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class ProductCategoryPage extends Page {
    public ProductCategoryPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
        globalPageHeader = new GlobalPageHeader(driver);
    }

    public void clickProductCategoryLink() {
        webElementActions.clickLink("productcategoty.page.item.link");
    }
}
