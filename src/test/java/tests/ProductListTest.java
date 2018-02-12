package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductListTest extends Fixtures {
    @BeforeMethod
    public void goToBasePage() {
        automation.goToProductListPage();
    }

    @Test
    public void isProductPresentInTheProductListTest() {
        Assert.assertFalse(automation.productListPage.isProductListEmpty(), "The product list is empty! Test failed!");
    }

    @Test
    public void productListIncludesValidProductAfterApplyPriceFilterTest() {
        automation.productListPage.clickRandomPriceRangeFilter();
        Assert.assertTrue(automation.productListPage.isProductInThePriceFilterRange(), "No valid product in the product list after apply price filter");
    }

    @Test
    public void productsOnTheProductListHaveAPriceTest() {
        Assert.assertTrue(automation.productListPage.isAllProductsHaveAPrice(), "Not all of products have a price! ");
    }

    @Test
    public void openingProductPageTest() {
        automation.productListPage.clickProductLinkFromTheProductList();
        Assert.assertTrue(automation.productPage.isAddToCartButtonPresent(), "Product page isn't open!");
    }

}
