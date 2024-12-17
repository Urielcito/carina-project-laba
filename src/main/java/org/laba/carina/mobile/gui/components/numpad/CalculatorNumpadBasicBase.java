package org.laba.carina.mobile.gui.components.numpad;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CalculatorNumpadBasicBase extends AbstractUIObject {
    public CalculatorNumpadBasicBase(WebDriver driver, SearchContext searchContext){super(driver, searchContext);}

    public abstract void enterNumber(int number);

    public abstract void clickPlusButton();

    public abstract void clickEqualsButton();

    public abstract void clickMultButton();

    public abstract void clickSubButton();

    public abstract void clickDivideButton();

    public abstract void clickModButton();
}
