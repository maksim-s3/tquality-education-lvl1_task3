package framework.utils;

import models.User;
import org.testng.annotations.DataProvider;

public class DPClass {
    @DataProvider(name = "TestCase3")
    public static Object[][] getDataTestCase3() {
        return new Object[][]{
                {new User("Jon", "Snow", "knowhothing@gmail.com", 30, 3000, "alpha")},
                {new User("Buttercup", "Cumbersnatch", "BudapestCandygram@mail.ru", 41, 2000, "beta")},
        };
    }
}