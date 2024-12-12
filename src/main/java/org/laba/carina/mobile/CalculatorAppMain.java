package org.laba.carina.mobile;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculatorAppMain extends MobileAbstractPage implements IAndroidUtils {
    @FindBy(id = "com.miui.calculator:id/gradient_mask_view")
    private ExtendedWebElement maskView;

    @FindBy(id = "com.miui.calculator:id/parentPanel")
    private ExtendedWebElement locationPermissionPanel;

    @FindBy(id = "android:id/button2")
    private ExtendedWebElement dontAgreeButton;

    @FindBy(id = "com.miui.calculator:id/digit_0")
    private ExtendedWebElement digitZero;

    @FindBy(id = "com.miui.calculator:id/digit_1")
    private ExtendedWebElement digitOne;

    @FindBy(id = "com.miui.calculator:id/digit_2")
    private ExtendedWebElement digitTwo;

    @FindBy(id = "com.miui.calculator:id/digit_3")
    private ExtendedWebElement digitThree;

    @FindBy(id = "com.miui.calculator:id/digit_4")
    private ExtendedWebElement digitFour;

    @FindBy(id = "com.miui.calculator:id/digit_5")
    private ExtendedWebElement digitFive;

    @FindBy(id = "com.miui.calculator:id/digit_6")
    private ExtendedWebElement digitSix;

    @FindBy(id = "com.miui.calculator:id/digit_7")
    private ExtendedWebElement digitSeven;

    @FindBy(id = "com.miui.calculator:id/digit_8")
    private ExtendedWebElement digitEight;

    @FindBy(id = "com.miui.calculator:id/digit_9")
    private ExtendedWebElement digitNine;

    @FindBy(id = "com.miui.calculator:id/op_add")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.miui.calculator:id/op_mul")
    private ExtendedWebElement multiplyButton;

    @FindBy(id = "com.miui.calculator:id/op_sub")
    private ExtendedWebElement substractButton;

    @FindBy(id = "com.miui.calculator:id/btn_equal_s")
    private ExtendedWebElement equalsButton;

    @FindBy(id = "com.miui.calculator:id/result")
    private ExtendedWebElement resultField;

    @FindBy(id = "com.miui.calculator:id/btn_switch")
    private ExtendedWebElement showMore;

    @FindBy(id = "com.miui.calculator:id/const_e")
    private ExtendedWebElement buttonE;

    @FindBy(id = "com.miui.calculator:id/lparen")
    private ExtendedWebElement leftParen;

    @FindBy(id = "com.miui.calculator:id/rparen")
    private ExtendedWebElement rightParen;

    @FindBy(id = "com.miui.calculator:id/op_pow")
    private ExtendedWebElement buttonPower;


    public ExtendedWebElement getNumberElementByDigit(char digit) {
        switch (digit) {
            case '0':
                return digitZero;
            case '1':
                return digitOne;
            case '2':
                return digitTwo;
            case '3':
                return digitThree;
            case '4':
                return digitFour;
            case '5':
                return digitFive;
            case '6':
                return digitSix;
            case '7':
                return digitSeven;
            case '8':
                return digitEight;
            case '9':
                return digitNine;
            default:
                throw new IllegalArgumentException("Invalid digit: " + digit);
        }
    }
    public CalculatorAppMain(WebDriver driver){super(driver);}

    public List<ExtendedWebElement> getNumberElements() {
        return Arrays.asList(digitOne, digitTwo, digitThree, digitFour, digitFive, digitSix, digitSeven, digitEight, digitNine, digitZero);
    }

    public List<ExtendedWebElement> getRandomNumbers(int count) {
        List<ExtendedWebElement> numbers = getNumberElements();
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }

    public void clickShowMore(){
        showMore.clickIfPresent();
    }

    public void clickPlusButton(){plusButton.clickIfPresent();}

    public void clickEqualsButton(){equalsButton.clickIfPresent();}

    public void clickMultButton(){multiplyButton.clickIfPresent();}

    public void clickDigitNine(){digitNine.clickIfPresent();}

    public void clickDigitFour(){digitFour.clickIfPresent();}

    public void clickDigitFive(){digitFive.clickIfPresent();}

    public void clickDigitTwo(){digitTwo.clickIfPresent();}

    public void clickLeftParen(){leftParen.clickIfPresent();}

    public void clickPowerButton(){buttonPower.clickIfPresent();}

    public void clickRightParen(){rightParen.clickIfPresent();}

    public void clickSubButton(){substractButton.clickIfPresent();}

    public boolean getResult(){
        return resultField.isElementPresent();
    }

    public String getResultText(){
        return resultField.getText();
    }

    public boolean isLocationPanelPresent(){
        return locationPermissionPanel.isPresent();
    }

    public void clickButtonE(){
        buttonE.clickIfPresent();
    }

    public void clickOnDontAgree(){
        if (isLocationPanelPresent())
            dontAgreeButton.clickIfPresent();
    }

    public boolean isOpened(long timeout) {
        return maskView.isElementPresent(timeout);
    }
    @Override
    public boolean isOpened() {

        return isOpened(DriverHelper.EXPLICIT_TIMEOUT);
    }
}
