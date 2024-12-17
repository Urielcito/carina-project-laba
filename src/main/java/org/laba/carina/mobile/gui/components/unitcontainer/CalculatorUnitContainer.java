package org.laba.carina.mobile.gui.components.unitcontainer;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CalculatorUnitContainer extends CalculatorUnitContainerBase implements ICustomTypePageFactory {
    @FindBy(xpath = "//android.widget.TextView")
    private List<ExtendedWebElement> unitContainerElements;

    public int getElementCount(){
        return unitContainerElements.size();
    }

    private ExtendedWebElement firstUnit = unitContainerElements.get(0);

    private ExtendedWebElement firstNumberField = unitContainerElements.get(1);


    private ExtendedWebElement secondUnit = unitContainerElements.get(2);


    private ExtendedWebElement secondNumberField = unitContainerElements.get(3);

    public int getFirstNumberField(){
        int num = -1;
        if(firstNumberField.isPresent()){
            num = Integer.valueOf(firstNumberField.getText());
        }
        return num;
    }

    public void clickOnFirstNumberField(){
        firstNumberField.clickIfPresent();
    }

    public int getSecondNumberField(){
        int num = -1;
        if(secondNumberField.isPresent()){
            String numString = secondNumberField.getText();
            numString = numString.replace(",", "");
            num = Integer.valueOf(numString);
        }
        return num;
    }

    public void clickOnSecondNumberField(){
        secondNumberField.clickIfPresent();
    }

    public String getFirstUnit(){
        return firstUnit.getText();
    }

    public String getSecondUnit(){
        return secondUnit.getText();
    }

    public boolean isOpened(){
        return this.isUIObjectPresent();
    }
    public CalculatorUnitContainer(WebDriver driver, SearchContext searchContext){super(driver,searchContext);}
}
