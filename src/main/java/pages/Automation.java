package pages;

import utils.ScreenShotMaker;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public class Automation {
    public WebElementsActions webElementsActions;
    public  HomePage homePage;
    public  RegPage regPage;
    public  CustomerPage customerPage;
    public  LoginPage loginPage;
    public  ProductListPage productListPage;
    public  ProductCategoryPage productCategoryPage;
    public GlobalPageHeader globalPageHeader;
    public ProductPage productPage;
    public ScreenShotMaker screenShotMaker;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutPage checkoutPage;


    public Automation(WebDriverWrapper driver) {

        globalPageHeader = new GlobalPageHeader(driver);
        homePage = new HomePage(driver);
        regPage = new RegPage(driver);
        customerPage = new CustomerPage(driver);
        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
        productCategoryPage = new ProductCategoryPage(driver);
        productPage = new ProductPage(driver);
        screenShotMaker = new ScreenShotMaker(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void goToProductListPage() {
        homePage.openPage();
        globalPageHeader.clickMenuCategotyLink();
        productCategoryPage.clickProductCategoryLink();
    }

    public void goToProductPage() {
        goToProductListPage();
        productListPage.clickProductLinkFromTheProductList();
    }

}
