package org.laba.carina.gui.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaActiveSandboxPage extends AbstractPage {
    @FindBy(id = "ca-edit")
    private ExtendedWebElement editButton;

    @FindBy(className = "mw-content-ltr")
    private ExtendedWebElement editedText;

    protected WikipediaActiveSandboxPage(WebDriver driver) {
        super(driver);
    }

    public WikipediaEditSandboxPage startEditing(){
        this.clickOnEdit();
        return new WikipediaEditSandboxPage(driver);
    }
    public void clickOnEdit(){
        editButton.clickIfPresent();
    }
    public Boolean editedTextContains(String text){
        return editedText.getText().contains(text);
    }

    public Boolean editedTextEquals(String text){
        return editedText.getText().equals(text);
    }

    public Boolean editedTextIsBold(String text){
        return editedText.getAttribute("innerHTML").contains("<b>" + text + "</b>");
    }
}
