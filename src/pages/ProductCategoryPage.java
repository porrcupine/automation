package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class ProductCategoryPage extends GlobalPageHeader {
    public ProductCategoryPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public void clickProductCategoryLink() {
        webElementActions.clickLink("productcategoty.page.item.link");
    }
}
