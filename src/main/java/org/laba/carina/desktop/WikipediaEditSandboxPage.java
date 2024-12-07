package org.laba.carina.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaEditSandboxPage extends AbstractPage {
    @FindBy(id = "wpTextbox1")
    private ExtendedWebElement textArea;

    @FindBy(id = "wpSave")
    private ExtendedWebElement publishButton;

    @FindBy(id = "wpPreview")
    private ExtendedWebElement previewButton;

    @FindBy(className = "mw-editform-cancel")
    private ExtendedWebElement cancelButton;

    @FindBy(css = "div.group-format:nth-child(1) > span:nth-child(1) > a:nth-child(1)")
    private ExtendedWebElement boldToggle;

    @FindBy(css = "span.oo-ui-flaggedElement-progressive:nth-child(2) > a:nth-child(1) > span:nth-child(2)")
    private ExtendedWebElement closePopUpButton;

    protected WikipediaEditSandboxPage (WebDriver driver){ super(driver);}

    public void write(String text){
        //WebDriverWait(driver, 1000000).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div[5]/div[3]/div/button/span'))).click()
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(new By.ById("wpTextbox1"))).click();
        String oldText = textArea.getText();
        textArea.type(oldText + "\n" + text);
    }

    public WikipediaActiveSandboxPage apply(){
        publishButton.clickIfPresent();
        return new WikipediaActiveSandboxPage(driver);
    }

    public void cancel(){

    }

    public void preview(){

    }

    public String getEditingText(){
        return textArea.getText();
    }

    public void closePopUpIfPresent(){
        closePopUpButton.clickIfPresent();
    }
}
