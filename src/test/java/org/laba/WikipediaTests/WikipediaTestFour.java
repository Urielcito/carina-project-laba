package org.laba.WikipediaTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.laba.carina.desktop.OurWikipediaHomePage;
import org.laba.carina.desktop.WikipediaDiscussionPage;
import org.laba.carina.desktop.WikipediaPolicyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTestFour implements IAbstractTest {
    @Test
    @MethodOwner(owner="nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name="test four",value={"web","regression"})
    public void testFour(){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");

        WikipediaPolicyPage policyPage = homePage.goToWikipediaPolicyPage(getDriver());
        Assert.assertEquals(policyPage.getDriver().getCurrentUrl(), "https://foundation.wikimedia.org/wiki/Policy:Privacy_policy", "Home page is not opened");
    }
}
