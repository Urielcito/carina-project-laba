package org.laba.carina.gui.common;

import org.testng.annotations.DataProvider;

public class testDataProvider {

    @DataProvider(name = "searchData")
    public static Object [][] dataProvider() {
        return new Object[][]{
                {"Argentina", "Argentina"},
        };
    }

    @DataProvider(name = "loginData")
    public static Object [][] loginDataProvider(){
        return new Object[][]{
                {"anUser1", "aPassword1"},
                {"anUser2", "aPassword2"},
                {"anUser3", "aPassword3"},
                {"anUser4", "aPassword4"},
                {"anUser5", "aPassword5"},
                {"anUser6", "aPassword6"},
        };
    }
}
