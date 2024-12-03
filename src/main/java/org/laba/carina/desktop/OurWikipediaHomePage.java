package org.laba.carina.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.laba.carina.common.OurWikipediaHomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OurWikipediaHomePageBase.class)
public class OurWikipediaHomePage extends OurWikipediaHomePageBase {

    @FindBy(id = "pt-createaccount-2")
    private ExtendedWebElement signUpBtn;

    @FindBy(id ="ca-talk")
    private ExtendedWebElement discussionsLink;

    @FindBy(id ="ca-viewsource")
    private ExtendedWebElement viewSourceCode;

    @FindBy(id ="vector-page-tools-dropdown-checkbox")
    private ExtendedWebElement toolbar;

    @FindBy(id ="vector-dropdown-content")
    private List<ExtendedWebElement> toolbarList;

    //method to handle toolbar selection
    public void selectInputDropdownOption(String optionText) {
        toolbar.clickIfPresent();
        for (ExtendedWebElement option : toolbarList) {
            if (option.getText().equals(optionText)) {
                option.click();
                return;
            }
        }
        throw new IllegalArgumentException("Option '" + optionText + "' not found in dropdown.");
    }

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

    public WikipediaSourceCodePage goToWikipediaSourceCodePage(WebDriver driver){
        openSourceCodePage();
        return new WikipediaSourceCodePage(driver);
    }

    public void openSignUp(){
        signUpBtn.clickIfPresent();
    }

    public void openDiscussionPage(){
        discussionsLink.clickIfPresent();
    }
    public void openSourceCodePage(){
        viewSourceCode.clickIfPresent();
    }
}

