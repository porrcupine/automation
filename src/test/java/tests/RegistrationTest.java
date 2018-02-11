package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Automation;

public class RegistrationTest extends Fixtures {
    private Automation automation = new Automation(driver);

    @Test
    public void newUserRegistrationTest() {
        automation.homePage.proceedToRegister();
        automation.regPage.enterName("Fedor");
        automation.regPage.lastName("Ivanov");
        automation.regPage.enterEmail("t223332211@gmail.com");
        automation.regPage.enterPassword("teatatata1234");
        automation.regPage.enterPasswordConfirm("teatatata1234");
        automation.regPage.clickRegButton();
        Assert.assertTrue(automation.customerPage.isRegistrationSuccessful(), "Registration test failed");
    }
}
