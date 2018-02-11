package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductListTest extends Fixtures {
    @BeforeMethod
    public void goToBasePage() {
        automation.homePage.openPage();
    }

    @Test
    public void isProductPresentInTheProductListTest() {
        automation.globalPageHeader.clickMenuCategotyLink();
        automation.productCategoryPage.clickProductCategoryLink();
        Assert.assertFalse(automation.productListPage.isProductListEmpty(), "The product list is empty! Test failed!");
    }

    @Test
    public void productListIncludesValidProductAfterApplyPriceFilterTest() {
        automation.goToProductListPage();
        automation.productListPage.clickRandomPriceRangeFilter();
        Assert.assertTrue(automation.productListPage.isProductInThePriceFilterRange(), "No valid product in the product list after apply price filter");
    }

}
