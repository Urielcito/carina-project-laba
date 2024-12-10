package org.example.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import org.example.carina.demo.mobile.gui.pages.common.ChartsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.solvd.carinademoapplication:id/pager_dots\"]/android.widget.ImageView[1]")
    private ExtendedWebElement firstView;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.solvd.carinademoapplication:id/pager_dots\"]/android.widget.ImageView[2]")
    private ExtendedWebElement secondView;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.solvd.carinademoapplication:id/pager_dots\"]/android.widget.ImageView[3]")
    private ExtendedWebElement thirdView;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.solvd.carinademoapplication:id/pager_dots\"]/android.widget.ImageView[4]")
    private ExtendedWebElement fourthView;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.solvd.carinademoapplication:id/pager_dots\"]/android.widget.ImageView[5]")
    private ExtendedWebElement fifthView;

    public ChartsPage cycleView(){
        firstView.click();
        secondView.click();
        thirdView.click();
        fourthView.click();
        fifthView.click();
        return initPage(getDriver(),ChartsPage.class);
    }

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isElementPresent();
    }

}
