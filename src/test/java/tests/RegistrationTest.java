package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends Fixtures {
    @BeforeMethod
    @Override
    public void goToBasePage() {
        automation.regPage.openPage();
    }

    @Test
    public void newUserRegistrationTest() {
        automation.regPage.enterNewUserDataAndClickRegister();
        Assert.assertTrue(automation.customerPage.isRegistrationSuccessful(), "Registration test failed");
    }


}
