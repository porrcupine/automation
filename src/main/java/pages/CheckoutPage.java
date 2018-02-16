package pages;

import utils.WebDriverWrapper;

/**
 * Created by SK on 2018-02-16
 */

public class CheckoutPage extends Page {
    private static final String page = "http://magento-demo.lexiconn.com/checkout/onepage/  ";

    public CheckoutPage(WebDriverWrapper dr) {
        super(dr, page);
    }

}
