package org.laba.carina.gui.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaLoginPage extends AbstractPage {
    @FindBy(id = "wpName1")
    private ExtendedWebElement userTextField;

    @FindBy(id = "wpPassword1")
    private ExtendedWebElement passwordTextField;

    @FindBy(id = "wpLoginAttempt")
    private ExtendedWebElement loginButton;

    @FindBy(className = "fancycaptcha-captcha-container")
    private ExtendedWebElement captchaContainer;

    public WikipediaLoginPage(WebDriver driver){super(driver);}

    public void clickOnLoginButton(){
        loginButton.clickIfPresent();
    }

    public void typeOnUserField(String text){
        userTextField.type(text);
    }

    public void typeOnPasswordField(String text){
        passwordTextField.type(text);
    }

    public boolean captchaAppeared(){
        return captchaContainer.isPresent();
    }

}
