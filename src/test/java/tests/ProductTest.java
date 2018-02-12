package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends Fixtures {

    @BeforeMethod
    @Override
    public void goToBasePage() {
        automation.goToProductPage();
    }

    @Test
    public void productPriceEqualsPriceInProductList() { //TODO DEBUG (govnoalgorithm)
        automation.productPage.setProductPriceForComparision();
        automation.goToProductListPage();
        automation.productListPage.setProductPriceForComparision();
        Assert.assertEquals(automation.productPage.getProductPrice(), automation.productListPage.getTempProductPrice(), "Prices on the product list and product details are not equals!");
    }
}
