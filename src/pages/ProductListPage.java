package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

import java.util.List;

public class ProductListPage extends Page {
    public ProductListPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
        globalPageHeader = new GlobalPageHeader(driver);
    }

    public List getProductList() {
        List list = webElementActions.getElements("productlist.page.items.list");
        return list;
    }

    public boolean isProductListEmpty() {
        if (getProductList().isEmpty()) {
            return true;
        }
        return false;
    }

    public void clickProductLinkFromTheList() {
        webElementActions.clickLink("productlist.page.item.link");
    }

}
