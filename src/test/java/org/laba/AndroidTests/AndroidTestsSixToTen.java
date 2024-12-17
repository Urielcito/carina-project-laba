package org.laba.AndroidTests;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.laba.carina.mobile.gui.components.numpad.CalculatorNumpadBasic;
import org.laba.carina.mobile.gui.components.unitcontainer.CalculatorUnitContainer;
import org.laba.carina.mobile.gui.pages.android.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class AndroidTestsSixToTen implements IAbstractTest {
    private static final Logger LOGGER = Logger.getLogger(AndroidTestsSixToTen.class);

    public void goToConverter(CalculatorAppMain appMain){
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());
        appMain.goToConverterScreen();
    }

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "verify length math", value = {"mobile", "acceptance"})
    public void verifyLengthMath() {
        int expectedFirstInitNumber = 1;
        int expectedSecondInitNumber = 100;
        int desiredFirstNumber = 5;
        int expectedSecondNumber = 5*100;
        String expectedFirstUnitContains = "Meter";
        String expectedSecondUnitContains = "Centimeter";

        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        goToConverter(appMain);

        CalculatorAppConverter appConverter = appMain.goToConverterScreen();
        Assert.assertTrue(appConverter.isOpened());

        CalculatorAppLengthConverter lengthConverter = appConverter.goToLengthConverter();
        Assert.assertTrue(lengthConverter.isOpened());

        CalculatorUnitContainer unitContainer = lengthConverter.getUnitContainer();

        Assert.assertEquals(unitContainer.getFirstNumberField(), expectedFirstInitNumber);
        Assert.assertEquals(unitContainer.getSecondNumberField(), expectedSecondInitNumber);

        CalculatorNumpadBasic numPad = lengthConverter.getNumpad();

        unitContainer.clickOnFirstNumberField();
        numPad.clickDeleteButton();
        numPad.enterNumber(desiredFirstNumber);

        String firstUnit = unitContainer.getFirstUnit();
        String secondUnit = unitContainer.getSecondUnit();
        double secondNumber = unitContainer.getSecondNumberField();

        Assert.assertTrue(firstUnit.contains(expectedFirstUnitContains) && secondUnit.contains(expectedSecondUnitContains), "Units are wrong.");

        Assert.assertEquals(secondNumber, expectedSecondNumber, "Math is wrong");
    }

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "verify mass math", value = {"mobile", "acceptance"})
    public void verifyMassMath() {
        int expectedFirstInitNumber = 1;
        int expectedSecondInitNumber = 1000;
        int desiredFirstNumber = 5;
        int expectedSecondNumber = 5*1000;
        String expectedFirstUnitContains = "Kilogram";
        String expectedSecondUnitContains = "Gram";

        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        goToConverter(appMain);

        CalculatorAppConverter appConverter = appMain.goToConverterScreen();
        Assert.assertTrue(appConverter.isOpened());

        CalculatorAppMassConverter massConverter = appConverter.goToMassConverter();
        Assert.assertTrue(massConverter.isOpened());

        CalculatorUnitContainer unitContainer = massConverter.getUnitContainer();

        Assert.assertEquals(unitContainer.getFirstNumberField(), expectedFirstInitNumber);
        Assert.assertEquals(unitContainer.getSecondNumberField(), expectedSecondInitNumber);

        CalculatorNumpadBasic numPad = massConverter.getNumpad();

        unitContainer.clickOnFirstNumberField();
        numPad.clickDeleteButton();
        numPad.enterNumber(desiredFirstNumber);

        String firstUnit = unitContainer.getFirstUnit();
        String secondUnit = unitContainer.getSecondUnit();
        double secondNumber = unitContainer.getSecondNumberField();

        Assert.assertTrue(firstUnit.contains(expectedFirstUnitContains) && secondUnit.contains(expectedSecondUnitContains), "Units are wrong.");

        Assert.assertEquals(secondNumber, expectedSecondNumber, "Math is wrong");


    }

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "verify area math", value = {"mobile", "acceptance"})
    public void verifyAreaMath() {
        int expectedFirstInitNumber = 1;
        int expectedSecondInitNumber = 10000;
        int desiredFirstNumber = 5;
        int expectedSecondNumber = 5*10000;
        String expectedFirstUnitContains = "Square meter";
        String expectedSecondUnitContains = "Square centimeter";

        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        goToConverter(appMain);

        CalculatorAppConverter appConverter = appMain.goToConverterScreen();
        Assert.assertTrue(appConverter.isOpened());

        CalculatorAppAreaConverter areaConverter = appConverter.goToAreaConverter();
        Assert.assertTrue(areaConverter.isOpened());

        CalculatorUnitContainer unitContainer = areaConverter.getUnitContainer();

        Assert.assertEquals(unitContainer.getFirstNumberField(), expectedFirstInitNumber);
        Assert.assertEquals(unitContainer.getSecondNumberField(), expectedSecondInitNumber);

        CalculatorNumpadBasic numPad = areaConverter.getNumpad();

        unitContainer.clickOnFirstNumberField();
        numPad.clickDeleteButton();
        numPad.enterNumber(desiredFirstNumber);

        String firstUnit = unitContainer.getFirstUnit();
        String secondUnit = unitContainer.getSecondUnit();
        double secondNumber = unitContainer.getSecondNumberField();

        Assert.assertTrue(firstUnit.contains(expectedFirstUnitContains) && secondUnit.contains(expectedSecondUnitContains), "Units are wrong.");

        Assert.assertEquals(secondNumber, expectedSecondNumber, "Math is wrong");

    }

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "verify operation gets saved to history", value = {"mobile", "acceptance"})
    public void verifyHistoryChanges(){
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        CalculatorNumpadBasic numPad = appMain.getNumpad();
        Assert.assertTrue(numPad.isUIObjectPresent());

        int firstNumber = 5, secondNumber = 100, expectedResult = 500;
        String expectedHistoryEntry = "5×100= 500";

        numPad.enterNumber(5);
        numPad.clickMultButton();
        numPad.enterNumber(100);
        numPad.clickEqualsButton();

        CalculatorAppHistory appHistory = appMain.goToHistory();

        Assert.assertTrue(appHistory.historyContainsOperation(expectedHistoryEntry), "Operation does not exist in the history.");
    }

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "verify history gets deleted", value = {"mobile", "acceptance"})
    public void verifyHistoryDeletion(){
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        CalculatorNumpadBasic numPad = appMain.getNumpad();
        Assert.assertTrue(numPad.isUIObjectPresent());

        int firstNumber = 5, secondNumber = 100, expectedResult = 500;
        String expectedHistoryEntry = "5×100= 500";

        numPad.enterNumber(firstNumber);
        numPad.clickMultButton();
        numPad.enterNumber(secondNumber);
        numPad.clickEqualsButton();

        CalculatorAppHistory appHistory = appMain.goToHistory();
        appHistory.deleteHistory();

        Assert.assertFalse(appHistory.historyContainsOperation(expectedHistoryEntry), "Operation does exist in the history.");
    }
}
