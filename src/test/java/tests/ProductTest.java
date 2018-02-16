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
<<<<<<< HEAD
    public void productPriceEqualsPriceInTheProductList() { //TODO DEBUG (govnoalgorithm)
=======
    public void productPriceEqualsPriceInProductListTest() { //TODO DEBUG (govnoalgorithm)
>>>>>>> skTestNG
        automation.productPage.setProductPriceForComparision();
        automation.goToProductListPage();
        automation.productListPage.setProductPriceForComparision();
        Assert.assertEquals(automation.productPage.getProductPrice(), automation.productListPage.getTempProductPrice(), "Prices on the product list and product details are not equals!");
    }

    @Test
    public void addProductToCartWithSelectedOptionsTest() {
        automation.productPage.selelectProductOptions();
        automation.productPage.clickAddToCartButton();
        Assert.assertTrue(automation.shoppingCartPage.isOpenPage(), "Product added to the cart!");
    }

    @Test
    public void addProductWithoutSelectedOptionsTest() {
        automation.productPage.clickAddToCartButton();
        Assert.assertFalse(automation.shoppingCartPage.isOpenPage(),"Product without selected options added to the cart!");
    }

    @Test
    public void addProductWithOneSelectedOptionTest() {
        automation.productPage.selectOneProductOption();
        automation.productPage.clickAddToCartButton();
        Assert.assertFalse(automation.shoppingCartPage.isOpenPage(),"Product without selected options added to the cart!");
    }

}
