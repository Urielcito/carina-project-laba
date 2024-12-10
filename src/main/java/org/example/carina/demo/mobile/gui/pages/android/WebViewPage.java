package org.example.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.example.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import org.example.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//*[text()='Get a quote']")
    private ExtendedWebElement contactUsLink;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private ExtendedWebElement navMenu;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"com.solvd.carinademoapplication:id/design_menu_item_text\" and @text=\"Map\"]\n")
    private ExtendedWebElement mapsPage;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"com.solvd.carinademoapplication:id/design_menu_item_text\" and @text=\"Charts\"]")
    private ExtendedWebElement chartsPage;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"com.solvd.carinademoapplication:id/design_menu_item_text\" and @text=\"UI elements\"]")
    private ExtendedWebElement uiElementsPage;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public MapsPage goToMapsPage(){
        navMenu.click();
        mapsPage.click();
        pause(2);
        return initPage(getDriver(),MapsPage.class);
    }
    @Override
    public ChartsPage goToChartsPage(){
        navMenu.click();
        chartsPage.click();
        pause(2);
        return initPage(getDriver(),ChartsPage.class);
    }
    @Override
    public UIElementsPage goToUiPage(){
        navMenu.click();
        uiElementsPage.click();
        pause(2);
        return initPage(getDriver(),UIElementsPage.class);
    }

    @Override
    public ContactUsPageBase goToContactUsPage() {
        swipe(contactUsLink);
        contactUsLink.click();
        pause(7);
        return initPage(getDriver(), ContactUsPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isElementPresent();
    }

}
