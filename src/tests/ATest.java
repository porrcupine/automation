package tests;

import browser.Browser;
import pages.*;

public abstract class ATest {

    public static HomePage homePage;
    public static RegPage regPage;
    public static CustomerPage customerPage;
    public static LoginPage loginPage;
    public static Browser browser;

    public void showTestName(String testName) {
        System.out.println("\n\n" + testName);
    }
}
