package pages;

import utils.WebDriverWrapper;

/**
 * Created by SK on 2018-02-16
 */

public class ShoppingCartPage extends Page {
    private static final String page = "http://magento-demo.lexiconn.com/checkout/cart/";

    public ShoppingCartPage(WebDriverWrapper dr) {
        super(dr, page);
    }

    public boolean isShoppingCartOpen() {
        return getCurrentPageURL().equals(page);
    }

    public void clickProceedToCheckoutButton() {
        webElementActions.clickButton("shopingcart.page.proceetccheckout.button");
    }

    public void clickEmptyCartButton() {
        webElementActions.clickButton("shopingcart.page.emptycart.button");
    }

    public boolean isShoppingCartEmpty() {
        return webElementActions.isElementPresent("shopingcart.page.emptycart.division");
    }
}
