package org.example.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class WebViewPageBase extends AbstractPage implements IMobileUtils {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChartsPageBase goToChartsPage();

    public abstract MapsPageBase goToMapsPage();

    public abstract UIElementsPageBase goToUiPage();

    public abstract ContactUsPageBase goToContactUsPage();

}
