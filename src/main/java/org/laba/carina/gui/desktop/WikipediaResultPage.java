package org.laba.carina.gui.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaResultPage extends AbstractPage {
    @FindBy(id = "firstHeading")
    private ExtendedWebElement pageTitle;

    protected WikipediaResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
