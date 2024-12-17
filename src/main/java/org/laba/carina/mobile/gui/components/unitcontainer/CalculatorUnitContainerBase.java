package org.laba.carina.mobile.gui.components.unitcontainer;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CalculatorUnitContainerBase extends AbstractUIObject {
    public CalculatorUnitContainerBase(WebDriver driver, SearchContext searchContext){super(driver, searchContext);}

    /*public abstract int getFirstNumberField();

    public abstract int getSecondNumberField();

    public abstract void clickOnFirstNumberField();

    public abstract void clickOnSecondNumberField();

    public abstract String getFirstUnit();

    public abstract String getSecondUnit();*/

    public abstract int getElementCount();

}
