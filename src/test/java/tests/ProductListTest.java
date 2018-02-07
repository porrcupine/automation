package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductListTest extends Fixtures {

    @Test
    public void isProductPresentInTheProductList() {
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink();
        Assert.assertFalse(productListPage.isProductListEmpty(),"The product list is empty! Test failed!");
    }

    @Test
    public void productListFilterPriceIncludesValidProductTest() {
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink();
        productListPage.clickRandomPriceRangeFilter();
        Assert.assertFalse(productListPage.isProductListEmpty(), "Product list is empty!" );
        Assert.assertTrue(productListPage.isProductInTheFilterPriceRange(), "No valid product in the product list after apply price filter");
    }

}
