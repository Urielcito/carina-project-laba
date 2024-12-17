package org.laba.carina.mobile.gui.components.numpad;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CalculatorNumpadBasic extends CalculatorNumpadBasicBase implements ICustomTypePageFactory {


    @FindBy(id = "com.miui.calculator:id/btn_c_1")
    private ExtendedWebElement clearButton;

    @FindBy(id = "com.miui.calculator:id/btn_del_1")
    private ExtendedWebElement deleteButton;

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

    @FindBy(id = "com.miui.calculator:id/dec_point")
    private ExtendedWebElement decimalButton;

    @FindBy(id = "com.miui.calculator:id/btn_percent_1")
    private ExtendedWebElement modButton;

    @FindBy(id = "com.miui.calculator:id/op_div")
    private ExtendedWebElement divideButton;

    @FindBy(id = "com.miui.calculator:id/op_mul")
    private ExtendedWebElement multiplyButton;

    @FindBy(id = "com.miui.calculator:id/op_sub")
    private ExtendedWebElement subtractButton;

    @FindBy(id = "com.miui.calculator:id/op_add")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.miui.calculator:id/btn_equal_s")
    private ExtendedWebElement equalsButton;

    private final List<ExtendedWebElement> numberList = Arrays.asList(digitZero, digitOne, digitTwo, digitThree, digitFour, digitFive, digitSix, digitSeven, digitEight, digitNine);

    private void clickOnDigitByNumber(int number){
        ExtendedWebElement digit = numberList.get(number);
        digit.clickIfPresent();
    }

    public void enterNumber(int number){
        String numberString = Integer.toString(number);
        for(int i = 0; i < numberString.length(); i++){
            char numberCharacter = numberString.charAt(i);
            int numberToPress = Character.getNumericValue(numberCharacter);
            clickOnDigitByNumber(numberToPress);
        }
    }

    public void clickPlusButton(){plusButton.clickIfPresent();}

    public void clickEqualsButton(){equalsButton.clickIfPresent();}

    public void clickMultButton(){multiplyButton.clickIfPresent();}

    public void clickSubButton(){
        subtractButton.clickIfPresent();}

    public void clickDivideButton(){divideButton.clickIfPresent();}

    public void clickModButton(){modButton.clickIfPresent();}

    public void clickDeleteButton(){deleteButton.clickIfPresent();}

    public void clickClearButton(){clearButton.clickIfPresent();}

    public CalculatorNumpadBasic(WebDriver driver, SearchContext searchContext){super(driver, searchContext);}
}
