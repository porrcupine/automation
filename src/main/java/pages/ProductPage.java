package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

public class ProductPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String page = "";
    private double productPrice;

    public ProductPage(WebDriverWrapper dr) {
        super(dr);
    }

    public double setProductPriceForComparision() {
        productPrice =  Double.valueOf(webElementActions.getElementText("product.page.price.text").replace("$", "").trim());
        return productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean isAddToCartButtonPresent() {
        return webElementActions.isElementPresent("product.page.addtocart.button");
    }
}
