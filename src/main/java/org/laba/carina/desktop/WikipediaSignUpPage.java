package org.laba.carina.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaSignUpPage extends AbstractPage {
    @FindBy(xpath="/html/body/div[2]/div/div[3]/main/div[3]/div[3]/div[3]/div[1]/form/div[1]/div[1]/label/span/span/a")
    private ExtendedWebElement usernamesBtn;

    public WikipediaSignUpPage(WebDriver driver) {super(driver);}

    public WikipediaUsernamesPage goToWikipediaUsernamesPage(){
        openUsernames();
        return new WikipediaUsernamesPage(driver);
    }

    public void openUsernames(){
        usernamesBtn.click();
    }
}
