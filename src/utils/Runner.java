package utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.LoginTest;
import tests.ProductListTest;
import tests.RegistrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        RegistrationTest.class,
        ProductListTest.class})

public class Runner {
}
