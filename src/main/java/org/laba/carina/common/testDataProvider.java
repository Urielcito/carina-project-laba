package org.laba.carina.common;

import org.testng.annotations.DataProvider;

public class testDataProvider {

    @DataProvider(name = "searchData")
    public static Object [][] dataProvider() {
        return new Object[][]{
                {"Argentina", "Argentina"},
        };
    }
}
