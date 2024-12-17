package org.laba.carina.mobile.gui.pages.android;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CalculatorAppConverter extends MobileAbstractPage implements IAndroidUtils {
    @FindBy(id = "com.miui.calculator:id/scrollView")
    private ExtendedWebElement scrollView;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Length\"]/android.widget.LinearLayout")
    private ExtendedWebElement lengthButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Mass\"]/android.widget.LinearLayout")
    private ExtendedWebElement massButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Area\"]/android.widget.LinearLayout")
    private ExtendedWebElement areaButton;

    public CalculatorAppConverter(WebDriver driver){super(driver);}

    public CalculatorAppLengthConverter goToLengthConverter(){
        clickOnLengthButton();
        return new CalculatorAppLengthConverter(driver);
    }

    public CalculatorAppMassConverter goToMassConverter(){
        clickOnMassButton();
        return new CalculatorAppMassConverter(driver);
    }

    public CalculatorAppAreaConverter goToAreaConverter(){
        clickOnAreaButton();
        return new CalculatorAppAreaConverter(driver);
    }

    public void clickOnLengthButton(){
        lengthButton.clickIfPresent();
    }

    public void clickOnMassButton(){
        massButton.clickIfPresent();
    }

    public void clickOnAreaButton(){
        areaButton.clickIfPresent();
    }

    public boolean isOpened(long timeout) {
        return scrollView.isElementPresent(timeout);
    }
    @Override
    public boolean isOpened() {
        return isOpened(DriverHelper.EXPLICIT_TIMEOUT);
    }
}
