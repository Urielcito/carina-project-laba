package org.laba.AndroidTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.laba.carina.mobile.gui.pages.android.CalculatorAppMain;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AndroidTestOne implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "Four one digit sums", value = {"mobile", "regression"})
    public void testOne(){
        R.CONFIG.put("capabilities.app", "D:\\Program Files (x86)\\Android\\app.apk", true);
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());

        List<ExtendedWebElement> firstSet = appMain.getRandomNumbers(4);
        List<ExtendedWebElement> secondSet = appMain.getRandomNumbers(4);

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int firstNum = Integer.parseInt(firstSet.get(i).getText());
            int secondNum = Integer.parseInt(secondSet.get(i).getText());
            sum += firstNum + secondNum;
        }

        for (int i = 0; i < 4; i++) {
            firstSet.get(i).click();
            appMain.clickPlusButton();
            secondSet.get(i).click();
            appMain.clickEqualsButton();
            Assert.assertTrue(appMain.getResult(),"Result not reached.");
        }

    }
}
