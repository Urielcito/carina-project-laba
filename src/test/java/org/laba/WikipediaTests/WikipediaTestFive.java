package org.laba.WikipediaTests;

import com.zebrunner.carina.core.IAbstractTest;
import org.laba.carina.common.testDataProvider;
import org.laba.carina.desktop.OurWikipediaHomePage;
import org.laba.carina.desktop.WikipediaResultPage;
import org.laba.carina.desktop.WikipediaSourceCodePage;
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
