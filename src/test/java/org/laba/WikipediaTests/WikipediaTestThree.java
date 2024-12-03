package org.laba.WikipediaTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.laba.carina.desktop.OurWikipediaHomePage;
import org.laba.carina.desktop.WikipediaDiscussionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTestThree implements IAbstractTest {

    @Test
    @MethodOwner(owner="nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name="test three",value={"web","regression"})
    public void testThree(){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");
        homePage.selectInputDropdownOption("Herramientas");
    }
}
