package laba;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.carina.demo.gui.pages.common.OurWikipediaHomePageBase;
import org.example.carina.demo.gui.pages.desktop.OurWikipediaHomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaSampleTest implements IAbstractTest{

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "test of the test", value = { "web", "regression" })
    public void test(){
        OurWikipediaHomePageBase homePage = initPage(getDriver(), OurWikipediaHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
}
