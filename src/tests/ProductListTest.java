package tests;

import browser.Firefox;
import org.testng.annotations.Test;


public class ProductListTest extends Fixtures {

    @Test
    public void isProductPresentInTheProductList() {
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink(); //TODO DEBUG
        if (productListPage.isProductListEmpty()) {
            throw new IllegalStateException();
        } else {
            System.out.println("Test is successful!");
        }
    }

}
