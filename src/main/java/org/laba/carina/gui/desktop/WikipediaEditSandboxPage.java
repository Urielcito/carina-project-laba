package org.laba.carina.gui.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.laba.carina.gui.components.enums.TextFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.time.Duration;
import java.util.List;

public class WikipediaEditSandboxPage extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(WikipediaEditSandboxPage.class);
    @FindBy(id = "wpTextbox1")
    private ExtendedWebElement textArea;

    @FindBy(id = "wpSave")
    private ExtendedWebElement publishButton;

    @FindBy(id = "wpPreview")
    private ExtendedWebElement previewButton;

    @FindBy(className = "mw-editform-cancel")
    private ExtendedWebElement cancelButton;

    @FindBy(className = "oo-ui-labelElement-label")
    private List<ExtendedWebElement> uiLabels;

    @FindBy(className = "ve-init-mw-welcomeDialog-content")
    private ExtendedWebElement welcomeMessage;

    protected WikipediaEditSandboxPage (WebDriver driver){ super(driver);}

    public void clickButtonByText(String text){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> welcomeMessage.isPresent());
        for(ExtendedWebElement button : uiLabels) {
            LOGGER.info("Button's get Text: "+button.getText());
            if (button.getText().equals(text)) {
                button.click();
                break;
            }
        }
    }
    public void clickTextArea(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> textArea.isClickable());
        textArea.click();
    }

    /**
     * Types given text into the text area.
     * @param text The text that you want to type.
     */
    public void typeInTextArea(String text){
        WebElement txtAreaWebElement = textArea.getElement();
        txtAreaWebElement.sendKeys(text);
        textArea.setElement(txtAreaWebElement);
    }

    /**
     * Types given text with the given format into the text area.
     * @param text The text that you want to type.
     * @param FORMAT The format that you want to use.
     */
    public void typeInTextArea(String text, TextFormat.Type FORMAT){
        WebElement txtAreaWebElement = textArea.getElement();
        String format = FORMAT.getValue();
        text = format + text + format;
        txtAreaWebElement.sendKeys(text);
        textArea.setElement(txtAreaWebElement);
    }

    public WikipediaActiveSandboxPage clickOnSaveButton(){
        publishButton.clickIfPresent();
        return new WikipediaActiveSandboxPage(driver);
    }

    public void clickOnCancelButton(){
        cancelButton.clickIfPresent();
    }

    public WikipediaEditSandboxPage clickOnPreviewButton(){
        previewButton.clickIfPresent();
        return new WikipediaEditSandboxPage(driver);
    }

    public String getEditingText(){
        return textArea.getText();
    }


}
