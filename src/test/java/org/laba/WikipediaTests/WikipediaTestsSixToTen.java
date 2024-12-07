package org.laba.WikipediaTests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.laba.carina.desktop.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class WikipediaTestsSixToTen implements IAbstractTest {
    private static final Logger LOGGER = Logger.getLogger(WikipediaTestsSixToTen.class);
    private static final String SANDBOX_REGEX = "https://es\\.wikipedia\\.org/wiki/Wikipedia:Zona_de_pruebas(/\\d{1,2})?";
    private static final String EDIT_REGEX = "https://es\\.wikipedia\\.org/w/index\\.php\\?title=Wikipedia:Zona_de_pruebas/([1-9]|10)&action=edit";

    private Boolean validatePageAgainstRegex(AbstractPage page, String regex){
        String URL = page.getDriver().getCurrentUrl();
        return URL.matches(regex);
    }

    /**
     * Searches for the sandbox page in Wikipedia and opens one of the available sandboxes.
     * @param homePage The main page of Wikipedia in SPANISH as a zebrunner POM.
     * @return The Page-Object-Model that represents a Wikipedia editable sandbox.
     */
    private WikipediaEditSandboxPage openActiveSandboxPage(OurWikipediaHomePage homePage){
        WikipediaSandboxPage sandboxPage = homePage.goToWikipediaSandboxPage();
        String currentUrl = sandboxPage.getDriver().getCurrentUrl();
        LOGGER.info("Opened URL: " + currentUrl);
        if (!currentUrl.equals("https://es.wikipedia.org/wiki/Wikipedia:Zona_de_pruebas")) {
            LOGGER.error("Search went wrong. URL: " + currentUrl);
        }

        WikipediaActiveSandboxPage activeSandboxPage = sandboxPage.clickOnFirstAvailableSandbox();
        if(activeSandboxPage == null){
            LOGGER.error("There's no available sandboxes at the moment, try again later.");
        } else if(!validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX)){
            LOGGER.error("There was an unknown error while trying to open an available sandbox.");
        }
        WikipediaEditSandboxPage editSandboxPage = activeSandboxPage.startEditing();
        if(!validatePageAgainstRegex(editSandboxPage, EDIT_REGEX))
            LOGGER.error("There was an unknown error while trying to edit the sandbox.");

        return editSandboxPage;
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "edit changes contents properly", value = {"web", "regression"})
    public void verifyEditedChangesRemainedAfterApplying(){ // Test #6
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaEditSandboxPage editSandboxPage = openActiveSandboxPage(homePage);
        editSandboxPage.closePopUpIfPresent();
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String text = "Something.";
        editSandboxPage.write("Something.");
        WikipediaActiveSandboxPage activeSandboxPage = editSandboxPage.apply();
        Assert.assertTrue(validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX), "Failed to get back to the active sandbox page.");
        Assert.assertTrue(activeSandboxPage.editedTextContains(text), "Failed to apply the changes to the page (Added text is not there)");
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "changes should not apply when we cancel the editing", value = {"web", "regression"})
    public void verifyEditedChangesDidNotRemainAfterCancelling(){
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaEditSandboxPage editSandboxPage = openActiveSandboxPage(homePage);
        editSandboxPage.closePopUpIfPresent();
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String oldText = editSandboxPage.getEditingText();
        String text = "Something.";
        String newText = oldText + "\n" + text;

        editSandboxPage.write("Something.");
        WikipediaActiveSandboxPage activeSandboxPage = editSandboxPage.apply();
        Assert.assertTrue(validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX), "Failed to get back to the active sandbox page.");
        Assert.assertFalse(activeSandboxPage.editedTextEquals(newText), "Failed to abort the changes to the page (The whole edited text is there)");
    }
}
