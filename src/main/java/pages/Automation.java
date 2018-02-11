package pages;

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

    public Automation(WebDriverWrapper driver) {
        this.webElementsActions = webElementsActions;
        homePage = new HomePage(driver);
        regPage = new RegPage(driver);
        customerPage = new CustomerPage(driver);
        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
        productCategoryPage = new ProductCategoryPage(driver);
    }
}
