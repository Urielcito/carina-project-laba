package org.laba.carina.desktop;

import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.laba.carina.common.OurWikipediaHomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OurWikipediaHomePageBase.class)
public class OurWikipediaHomePage extends OurWikipediaHomePageBase {

    @FindBy(id = "pt-createaccount-2")
    private ExtendedWebElement signUpBtn;

    @FindBy(id ="ca-talk")
    private ExtendedWebElement discussionsLink;

    public OurWikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public WikipediaSignUpPage goToWikipediaSignUpPage(WebDriver driver) {
        openSignUp();
        return new WikipediaSignUpPage(driver);
    }

    public WikipediaDiscussionPage goToWikipediaDiscussionPage(WebDriver driver){
        openDiscussionPage();
        return new WikipediaDiscussionPage(driver);
    }

    public void openSignUp(){
        signUpBtn.clickIfPresent();
    }

    public void openDiscussionPage(){
        discussionsLink.clickIfPresent();
    }
}

