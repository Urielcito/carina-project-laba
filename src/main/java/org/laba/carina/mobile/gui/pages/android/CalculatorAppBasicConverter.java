package org.laba.carina.mobile.gui.pages.android;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.laba.carina.mobile.gui.components.numpad.CalculatorNumpadBasic;
import org.laba.carina.mobile.gui.components.unitcontainer.CalculatorUnitContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CalculatorAppBasicConverter extends MobileAbstractPage implements IAndroidUtils {

    @FindBy(id = "com.miui.calculator:id/nbp_pad_wrapper")
    protected CalculatorNumpadBasic numPad;

    @FindBy(id = "com.miui.calculator:id/unit_view_container")
    protected CalculatorUnitContainer unitContainer;

    public CalculatorAppBasicConverter(WebDriver driver) {
        super(driver);
    }

    public CalculatorUnitContainer getUnitContainer() {
        return unitContainer;
    }

    public CalculatorNumpadBasic getNumpad() {
        return numPad;
    }

    public boolean isOpened(long timeout) {
        return unitContainer.isUIObjectPresent() && numPad.isUIObjectPresent(timeout);
    }

    @Override
    public boolean isOpened() {
        return isOpened(DriverHelper.EXPLICIT_TIMEOUT);
    }
}
