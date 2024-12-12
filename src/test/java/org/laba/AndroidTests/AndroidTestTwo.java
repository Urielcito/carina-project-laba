package org.laba.AndroidTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.laba.carina.mobile.CalculatorAppMain;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AndroidTestTwo implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "Four one digit sum", value = {"mobile", "regression"})
    public void testTwo(){
        R.CONFIG.put("capabilities.app", "D:\\Program Files (x86)\\Android\\app.apk",true);
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());

        List<ExtendedWebElement> randomDigits = appMain.getRandomNumbers(8);
        StringBuilder firstNumberBuilder = new StringBuilder();
        StringBuilder secondNumberBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            firstNumberBuilder.append(randomDigits.get(i).getText());
        }
        int firstNumber = Integer.parseInt(firstNumberBuilder.toString());

        for (int i = 4; i < 8; i++) {
            secondNumberBuilder.append(randomDigits.get(i).getText());
        }
        int secondNumber = Integer.parseInt(secondNumberBuilder.toString());

        int expectedSum = firstNumber + secondNumber;
        for (char digit : firstNumberBuilder.toString().toCharArray()) {
            appMain.getNumberElementByDigit(digit).click();
        }
        appMain.clickPlusButton();
        for (char digit : secondNumberBuilder.toString().toCharArray()) {
            appMain.getNumberElementByDigit(digit).click();
        }
        appMain.clickEqualsButton();
        String rawResult = appMain.getResultText();
        String actualResult = rawResult.replace("=", "").replace(",", "").trim();
        Assert.assertEquals(Integer.parseInt(actualResult), expectedSum, "Sum does not match.");
    }
}
