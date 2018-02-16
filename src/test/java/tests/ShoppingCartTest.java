package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by SK on 2018-02-16
 */

public class ShoppingCartTest extends Fixtures {

    @BeforeMethod
    @Override
    public void goToBasePage() {
        automation.shoppingCartPage.openPage();
    }

    @Test
    public void proceedToCheckoutTest() {
        automation.shoppingCartPage.clickProceedToCheckoutButton();
        Assert.assertTrue(automation.checkoutPage.isOpenPage(), "Checkout fail!");

    }

    @Test
    public void emptyShoppingCartTest() {
        automation.goToProductPage();
        automation.productPage.selelectProductOptions();
        automation.productPage.clickAddToCartButton();
        automation.shoppingCartPage.clickEmptyCartButton();
        Assert.assertTrue(automation.shoppingCartPage.isShoppingCartEmpty(), "Cart is not empty!");
    }
}
