package org.laba.WikipediaTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.laba.carina.gui.desktop.OurWikipediaHomePage;
import org.laba.carina.gui.desktop.WikipediaDiscussionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTestOne implements IAbstractTest {

    @Test
    @MethodOwner(owner="nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name="test one",value={"web","regression"})
    public void testOne(){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");

        WikipediaDiscussionPage discussionPage = homePage.goToWikipediaDiscussionPage();
        Assert.assertEquals(discussionPage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia_discusi%C3%B3n:Portada", "Home page is not opened");
    }
}
