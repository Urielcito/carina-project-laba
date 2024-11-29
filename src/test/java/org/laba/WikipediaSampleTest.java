package org.laba;

import com.zebrunner.carina.core.IAbstractTest;
import org.laba.carina.common.OurWikipediaHomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.laba.carina.desktop.OurWikipediaHomePage;
import org.laba.carina.desktop.WikipediaSignUpPage;
import org.laba.carina.desktop.WikipediaUsernamesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaSampleTest implements IAbstractTest{

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "test of the test", value = { "web", "regression" })
    public void testPageOpens(){
        OurWikipediaHomePageBase homePage = initPage(getDriver(), OurWikipediaHomePageBase.class);
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "home->sign up->username politics", value = {"web", "regression"})
    public void testThreePagesThreeAsserts(){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Portada", "Home page is not opened");

        WikipediaSignUpPage wikipediaSignUpPage = homePage.goToWikipediaSignUpPage(getDriver());

        Assert.assertEquals(wikipediaSignUpPage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/w/index.php?title=Especial:Crear_una_cuenta&returnto=Wikipedia%3APortada", "Home page is not opened");

        WikipediaUsernamesPage wikipediaUsernamesPage = wikipediaSignUpPage.goToWikipediaUsernamesPage(getDriver());
        Assert.assertEquals(wikipediaUsernamesPage.getDriver().getCurrentUrl(), "https://es.wikipedia.org/wiki/Wikipedia:Nombres_de_usuario", "Home page is not opened");


    }

}