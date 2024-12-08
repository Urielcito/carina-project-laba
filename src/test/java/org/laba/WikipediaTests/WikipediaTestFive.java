package org.laba.WikipediaTests;

import com.zebrunner.carina.core.IAbstractTest;
import org.laba.carina.gui.common.testDataProvider;
import org.laba.carina.gui.desktop.OurWikipediaHomePage;
import org.laba.carina.gui.desktop.WikipediaResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTestFive implements IAbstractTest {

    @Test(dataProvider = "searchData", dataProviderClass = testDataProvider.class)
    public void testSearchBar(String data, String expectedTitle){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");

        WikipediaResultPage resultPage= homePage.search(data);
        String actualTitle = resultPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle,
                "The page does not match the search parameter");
    }
}
