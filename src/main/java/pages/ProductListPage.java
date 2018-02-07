package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebElementActions;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ProductListPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductListPage(WebDriver driver) {
        webElementActions = new WebElementActions(driver);
    }

    public List getProductList() {
        List list = webElementActions.getElements("productlist.page.items.list");
        return list;
    }

    public HashMap<String, Double> getFilterRangeValues() {
        String stringPriceRange = webElementActions.getElementText("productlist.page.filter.price.selectedrange.text");
        String[] strings = stringPriceRange.split("-");
        double rangeFrom = Double.valueOf(strings[0].replace("$","").trim());
        double rangeTo = Double.valueOf(strings[0].replace("$","").trim());
        HashMap<String,Double> hashMap = new HashMap();
        hashMap.put("rangeFrom",rangeFrom);
        hashMap.put("rangeTo", rangeTo);
        return hashMap;
    }

    public double getProductPrice() {
        String stringPrice = webElementActions.getElementText("productlist.page.items.price.text");
        double productPrice = Double.valueOf(stringPrice.replace("$", "").trim());
        return productPrice;
    }

    public boolean isProductListEmpty() {
        return getProductList().isEmpty();
    }

    public boolean isProductInTheFilterPriceRange() {
        return ((getProductPrice() >= getFilterRangeValues().get("rangeFrom")) && (getProductPrice() <= getFilterRangeValues().get("rangeTo")));
    }

    public void clickRandomPriceRangeFilter() {
        Random random = new Random();
        int randomElementNumber = random.nextInt(Integer.valueOf(PropertyLoader.loadProperty("filter.numberOfElementInOrder")) - 1);
        webElementActions.clickSpecifiedLinkFromTheList("productlist.page.filter.price.list", randomElementNumber );
    }

    public void clickProductLinkFromTheList() {
        webElementActions.clickLink("productlist.page.item.link");
    }



}
