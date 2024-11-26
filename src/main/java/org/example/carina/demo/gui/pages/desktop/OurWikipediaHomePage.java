package org.example.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.example.carina.demo.gui.pages.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.carina.demo.gui.components.footer.FooterMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OurWikipediaHomePageBase.class)
public class OurWikipediaHomePage extends OurWikipediaHomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public OurWikipediaHomePage(WebDriver driver) {
        super(driver);
    }
}

