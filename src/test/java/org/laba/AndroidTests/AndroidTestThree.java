package org.laba.AndroidTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.laba.carina.mobile.gui.pages.android.CalculatorAppMain;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTestThree implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "check value of e", value = {"mobile", "regression"})
    public void testThree(){
        R.CONFIG.put("capabilities.app", "D:\\Program Files (x86)\\Android\\app.apk",true);
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());

        appMain.clickShowMore();
        appMain.clickButtonE();
        appMain.clickEqualsButton();
        String rawResult = appMain.getResultText();
        String actualResult = rawResult.replace("=", "").trim();
        Assert.assertTrue(actualResult.contains("2.71828"), "Value of e does not match.");
    }
}
