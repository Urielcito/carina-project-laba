package org.example.carina.demo.gui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class OurWikipediaHomePageBase extends AbstractPage{

    @FindBy(id = "searchform")
    private ExtendedWebElement inputSearch;

    public void prueba(){
        inputSearch.toString();
    }
    public OurWikipediaHomePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(){
        super.open();
    }
}
