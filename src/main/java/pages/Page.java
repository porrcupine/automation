package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public abstract class Page {
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public WebDriverWrapper webDriverWrapper;
    public WebElementsActions webElementActions;

    private String PAGE;

    public Page(WebDriverWrapper dr, String page) {
        webDriverWrapper = dr;
        PAGE = page;
        webElementActions = new WebElementsActions(dr);
    }

    public Page(WebDriverWrapper dr) {
        webDriverWrapper = dr;
        webElementActions = new WebElementsActions(dr);
    }

    /*
     * Open Page in a browser
     */
    public boolean openPage() {
        try {
            LOG.info("Start open page.");
            webDriverWrapper.get(PAGE);
            webDriverWrapper.getCurrentUrl();
        } catch (Exception e) {
            LOG.error("Error in open page!\n");
            return false;
        }
        LOG.info("Page open successful.");
        return true;
    }

    /*
     * Verification Page open correct. Check on pageLocator
     */
    public boolean isOpenPage(String checkLocator) {
        if (webElementActions.isElementPresent(checkLocator)) {
            LOG.info("Page: Check is page open. " + checkLocator + " is present!");
            LOG.info(ClassNameUtil.getCurrentClassName() + ": Page is open.");
            return true;
        } else {
            LOG.error("Page: Error with check page!\n");
            Assert.fail("Incorrect swatch");
        }
        return false;
    }

    public boolean isOpenPage() {
        return getCurrentPageURL().equals(PAGE);

    }
    /*
     * Get page title for verification correct switch between pages
     */

    public String getTitle() {
        return webDriverWrapper.getTitle();
    }

    public String getCurrentPageURL() {
        return webDriverWrapper.getCurrentUrl();
    }


}

