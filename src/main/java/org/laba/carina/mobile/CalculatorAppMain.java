package org.laba.carina.mobile;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CalculatorAppMain extends MobileAbstractPage implements IAndroidUtils {
    @FindBy(id = "com.miui.calculator:id/gradient_mask_view")
    private ExtendedWebElement maskView;

    @FindBy(id = "com.miui.calculator:id/digit_1")
    private ExtendedWebElement digitOne;

    public CalculatorAppMain(WebDriver driver){super(driver);}

    public void clickOnNumberOne(){
        digitOne.clickIfPresent();
    }





    public boolean isOpened(long timeout) {
        return maskView.isElementPresent(timeout);
    }
    @Override
    public boolean isOpened() {

        return isOpened(DriverHelper.EXPLICIT_TIMEOUT);
    }
}
