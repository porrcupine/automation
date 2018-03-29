package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ProductListPage extends GlobalPageHeader {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String page = "";
    private double tempProductPrice;

    public ProductListPage(WebDriverWrapper dr) {
        super(dr);
    }

    private double getProductPrice() {
        String stringPrice = webElementActions.getElementText("productlist.page.items.price.text");
        double productPrice = Double.valueOf(stringPrice.replace("$", "").trim());
        return productPrice;
    }

    public double getTempProductPrice() {
        return tempProductPrice;
    }

    private List getProductList() {
        List list = webElementActions.getElements("productlist.page.items.list");
        return list;
    }

    private List getProductPriceList() {
        List list = webElementActions.getElements("productlist.page.item.price.list");
        return list;
    }

    private HashMap<String, Double> getFilterRangeValues() {
        String stringPriceRange = webElementActions.getElementText("productlist.page.filter.price.selectedrange.text");
        String[] strings = stringPriceRange.split("-");
        double rangeFrom = Double.valueOf(strings[0].replace("$", "").trim());
        double rangeTo = Double.valueOf(strings[0].replace("$", "").trim());
        HashMap<String, Double> hashMap = new HashMap();
        hashMap.put("rangeFrom", rangeFrom);
        hashMap.put("rangeTo", rangeTo);
        return hashMap;
    }

    public void setProductPriceForComparision() {
        tempProductPrice = getProductPrice();
    }

    public void clickRandomPriceRangeFilter() {
        Random random = new Random();
        int randomElementNumber = random.nextInt(Integer.valueOf(PropertyLoader.loadProperty("filter.numberOfElementInOrder")) - 1);
        webElementActions.clickSpecifiedLinkFromTheList("productlist.page.filter.price.list", randomElementNumber);
    }

    public void clickProductLinkFromTheProductList() {
        webElementActions.clickLink("productlist.page.item.link");
    }

    public boolean isProductInThePriceFilterRange() {
        return ((getProductPrice() >= getFilterRangeValues().get("rangeFrom")) && (getProductPrice() <= getFilterRangeValues().get("rangeTo")));
    }

    public boolean isProductListEmpty() {
        return getProductList().isEmpty();
    }

    public boolean isAllProductsHaveAPrice() {
        return getProductList().size() == getProductPriceList().size();
    }

    public boolean isFilterPresent() {
        return webElementActions.isElementPresent("productlist.page.item.filter");
    }


}
