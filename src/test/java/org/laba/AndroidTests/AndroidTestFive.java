package org.laba.AndroidTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.laba.carina.mobile.gui.pages.android.CalculatorAppMain;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTestFive implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "(a+b)2 = a2+2ab+b2", value = {"mobile", "regression"})
    public void testFour() {

        R.CONFIG.put("capabilities.app", "D:\\Program Files (x86)\\Android\\app.apk", true);
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());

        //(a+b)2
        appMain.clickShowMore();

        appMain.clickLeftParen();
        appMain.clickDigitFour();
        appMain.clickPlusButton();
        appMain.clickDigitFive();
        appMain.clickRightParen();

        appMain.clickPowerButton();
        appMain.clickDigitTwo();

        appMain.clickEqualsButton();
        String firstRawResult = appMain.getResultText();
        String firstResult= firstRawResult.replace("=", "").trim();

        //a2+2ab+b2
        appMain.clickDigitFour();
        appMain.clickPowerButton();
        appMain.clickDigitTwo();

        appMain.clickPlusButton();

        appMain.clickDigitTwo();
        appMain.clickMultButton();
        appMain.clickDigitFour();
        appMain.clickMultButton();
        appMain.clickDigitFive();

        appMain.clickPlusButton();

        appMain.clickDigitFive();
        appMain.clickPowerButton();
        appMain.clickDigitTwo();

        appMain.clickEqualsButton();
        String secondRawResult = appMain.getResultText();
        String secondResult= secondRawResult.replace("=", "").trim();

        Assert.assertEquals(firstResult,secondResult,"Results are not the same.");
    }
}
