package org.laba.carina.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WikipediaSandboxPage extends AbstractPage {
    @FindBy(css = "table.wikitable td img")
    private List<ExtendedWebElement> tableImages;

    protected WikipediaSandboxPage(WebDriver driver) {
        super(driver);
    }

    public WikipediaActiveSandboxPage clickOnFirstAvailableSandbox(){
        for (ExtendedWebElement tableImage : tableImages) {
            if(tableImage.getAttribute("srcset").contains("Green")){
                tableImage.click();
                return new WikipediaActiveSandboxPage(driver);
            }
        }
        return null;
    }

}
