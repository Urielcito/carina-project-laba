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

    @FindBy(id ="vector-main-menu-dropdown")
    private ExtendedWebElement openMainMenu;

    @FindBy(className ="vector-pinnable-header-toggle-button")
    private ExtendedWebElement moveMenu;

    @FindBy(xpath ="//*[@id=\"skin-client-prefs-vector-feature-custom-font-size\"]/div[2]/ul/li/div/form/div[1]")
    private ExtendedWebElement smallText;

    @FindBy(xpath ="//*[@id=\"skin-client-prefs-vector-feature-custom-font-size\"]/div[2]/ul/li/div/form/div[2]")
    private ExtendedWebElement mediumText;

    @FindBy(xpath ="//*[@id=\"skin-client-prefs-vector-feature-custom-font-size\"]/div[2]/ul/li/div/form/div[3]")
    private ExtendedWebElement bigText;

    @FindBy(className ="vector-page-tools-landmark")
    private ExtendedWebElement toolbar;

    @FindBy(id ="t-upload")
    private ExtendedWebElement uploadFile;

    @FindBy(id ="footer-places-privacy")
    private ExtendedWebElement policyPage;

    @FindBy(className ="cdx-text-input__input")
    private ExtendedWebElement searchBar;

   //@FindBy(className ="cdx-button cdx-button--action-default cdx-button--weight-normal")
    @FindBy(className = "cdx-button")
    private ExtendedWebElement searchButton;

    public void selectInputDropdown() {
        toolbar.clickIfPresent();
    }

    public void selectMainMenu(){
        openMainMenu.clickIfPresent();
    }

    public void moveMenu(){
        moveMenu.clickIfPresent();
    }

    public void checkSmallText(){
        smallText.clickIfPresent();
    }

    public void checkMediumText(){
        mediumText.clickIfPresent();
    }

    public void checkBigText(){
        bigText.clickIfPresent();
    }

    public OurWikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public WikipediaSignUpPage goToWikipediaSignUpPage(WebDriver driver) {
        openSignUp();
        return new WikipediaSignUpPage(driver);
    }

    public WikipediaUploadPage goToWikipediaUploadPage(WebDriver driver){
        openUploadPage();
        return new WikipediaUploadPage(driver);
    }

    public WikipediaDiscussionPage goToWikipediaDiscussionPage(WebDriver driver){
        openDiscussionPage();
        return new WikipediaDiscussionPage(driver);
    }


    public WikipediaPolicyPage goToWikipediaPolicyPage(WebDriver driver){
        openPolicyPage();
        return new WikipediaPolicyPage(driver);
    }

    public WikipediaResultPage search(String data){
        searchBar.type(data);
        searchButton.clickIfPresent();
        return new WikipediaResultPage(driver);
    }

    public void openSignUp(){
        signUpBtn.clickIfPresent();
    }

    public void openArgentinaPage(){

    }

    public void openDiscussionPage(){
        discussionsLink.clickIfPresent();
    }

    public void openUploadPage(){
        uploadFile.clickIfPresent();
    }

    public void openPolicyPage(){
        policyPage.clickIfPresent();
    }
}

