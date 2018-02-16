package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

import java.util.List;

public class ProductPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static int productOpitionItemNumber = 1;
    private static String page = "";
    private double productPrice;

    public ProductPage(WebDriverWrapper dr) {
        super(dr);
    }

    public double setProductPriceForComparision() {
        productPrice = Double.valueOf(webElementActions.getElementText("product.page.price.text").replace("$", "").trim());
        return productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void selelectProductOptions() {
        List<WebElement> optionsList = webElementActions.getElements("product.page.options.select.list");
        if (optionsList.size() > 0) {
            for (int i = 0; i < optionsList.size(); i++) {
                webElementActions.selectOptionFromDropDown(optionsList.get(i), webElementActions.getAllDropDownOprions(optionsList.get(i)).size() - 1);
            }
        }
    }

    public void selectOneProductOption() {
        WebElement drp = webElementActions.getElement("product.page.options.select.list");
        webElementActions.selectOptionFromDropDown(drp, productOpitionItemNumber);
    }

    public void clickAddToCartButton() {
        webElementActions.clickButton("product.page.addtocart.button");
    }


    public boolean isAddToCartButtonPresent() {
        return webElementActions.isElementPresent("product.page.addtocart.button");
    }

}
