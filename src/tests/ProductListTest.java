package tests;

import browser.Firefox;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductListTest extends Fixtures {

    @Test
    public void isProductPresentInTheProductList() {
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink(); //TODO DEBUG
        Assert.assertFalse(productListPage.isProductListEmpty(),"Product list is empty! Test failed!");
    }

}
