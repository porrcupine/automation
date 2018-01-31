package tests;

import browser.Firefox;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;
import pages.ProductCategoryPage;
import pages.ProductListPage;

public class ProductListTest extends ATest{

    @BeforeClass
    public static void setUp() {
        browser = new Firefox();
        browser.configure();
        homePage = new HomePage(browser.driver);
        productListPage = new ProductListPage(browser.driver);
        productCategoryPage = new ProductCategoryPage(browser.driver);
    }

    @Test
    public void isProductPresentInTheProductList() {
        showTestName("Is product present in the product list test");
        browser.deleteAllCookies();
        browser.getTestUrl();
        homePage.clickMenuCategoryLink();
        productCategoryPage.clickProductCategoryLink(); //TODO DEBUG
        if (productListPage.isProductListEmpty()) {
            throw new IllegalStateException();
        } else {
            System.out.println("Test is successful!");
        }
    }

    @AfterClass
    public static void tearDown() {
        browser.tearDown();
    }

}
