package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends Fixtures {

    @Test
    public void newUserRegistrationTest() {
        homePage.register();
        regPage.enterName("Fedor");
        regPage.lastName("Ivanov");
        regPage.enterEmail("t223332211@gmail.com");
        regPage.enterPassword("teatatata1234");
        regPage.enterPasswordConfirm("teatatata1234");
        regPage.clickRegButton();
        Assert.assertTrue(customerPage.isRegistrationSuccessful(), "Registration test failed");
    }
}
