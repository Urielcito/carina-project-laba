package org.laba.carina.mobile.gui.pages.android;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.List;

public class CalculatorAppHistory extends MobileAbstractPage implements IAndroidUtils {
    Logger LOGGER = Logger.getLogger(CalculatorAppHistory.class);
    @FindBy(id = "com.miui.calculator:id/action_bar_title")
    private ExtendedWebElement historyTitle;

    @FindBy(id = "com.miui.calculator:id/recycler_view")
    private ExtendedWebElement recyclerView;

    @FindBy(id = "com.miui.calculator:id/expression")
    private List<ExtendedWebElement> historyItems;

    @FindBy(id = "com.miui.calculator:id/action_bar_delete")
    private ExtendedWebElement deleteButton;

    @FindBy(id = "android:id/button2")
    private ExtendedWebElement selectAllButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.miui.calculator:id/action_menu_item_child_text\" and @text=\"Delete\"]")
    private ExtendedWebElement deleteHistoryButton;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement confirmDeletionButton;

    public void deleteHistory(){
        clickDeleteButton();
        clickSelectAllButton();
        clickDeleteHistoryButton();
        clickConfirmDeletionButton();
    }
    public void clickSelectAllButton(){
        selectAllButton.clickIfPresent();
    }

    public void clickDeleteHistoryButton(){
        deleteHistoryButton.clickIfPresent();
    }

    public void clickConfirmDeletionButton(){
        confirmDeletionButton.clickIfPresent();
    }

    public void clickDeleteButton(){
        deleteButton.clickIfPresent();
    }
    public boolean historyContainsOperation(String op){
        for (ExtendedWebElement element : historyItems){
            LOGGER.info(element.getText());
            if(element.getText().equals(op))
            {
                return true;
            }
        }
        return false;
    }

    public CalculatorAppHistory(WebDriver driver){super(driver);}
    public boolean isOpened(long timeout) {
        return historyTitle.isElementPresent(timeout) && historyTitle.getText().equals("History");
    }
    @Override
    public boolean isOpened() {

        return isOpened(DriverHelper.EXPLICIT_TIMEOUT);
    }
}
