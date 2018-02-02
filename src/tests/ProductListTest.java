package tests;

import browser.Firefox;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;
import pages.ProductCategoryPage;
import pages.ProductListPage;

public class ProductListTest extends BaseTest {

    public static void setUp() {
        browserFirefox = new Firefox();
        browserFirefox.configure();
        homePage = new HomePage(browserFirefox.driver);
        productListPage = new ProductListPage(browserFirefox.driver);
        productCategoryPage = new ProductCategoryPage(browserFirefox.driver);
    }

    @Test
    public void isProductPresentInTheProductList() {
        showTestName("Is product present in the product list test");
        browserFirefox.deleteAllCookies();
        browserFirefox.getTestUrl();
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink(); //TODO DEBUG
        if (productListPage.isProductListEmpty()) {
            throw new IllegalStateException();
        } else {
            System.out.println("Test is successful!");
        }
    }

}
