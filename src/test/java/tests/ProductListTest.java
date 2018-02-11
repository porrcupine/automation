package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Automation;


public class ProductListTest extends Fixtures {
    private Automation automation = new Automation(driver);

    @Test
    public void isProductPresentInTheProductList() {
        automation.homePage.clickMenuCategoryLink();
        automation.productCategoryPage.clickProductCategoryLink();
        Assert.assertFalse(automation.productListPage.isProductListEmpty(), "The product list is empty! Test failed!");
    }

    @Test
    public void productListFilterPriceIncludesValidProductTest() {
        automation.homePage.clickMenuCategoryLink();
        automation.productCategoryPage.clickProductCategoryLink();
        automation.productListPage.clickRandomPriceRangeFilter();
        Assert.assertFalse(automation.productListPage.isProductListEmpty(), "Product list is empty!");
        Assert.assertTrue(automation.productListPage.isProductInTheFilterPriceRange(), "No valid product in the product list after apply price filter");
    }

}
