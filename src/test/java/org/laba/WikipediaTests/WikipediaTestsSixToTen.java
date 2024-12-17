package org.laba.WikipediaTests;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.laba.carina.gui.common.testDataProvider;
import org.laba.carina.gui.components.enums.TextFormat;
import org.laba.carina.gui.desktop.OurWikipediaHomePage;
import org.laba.carina.gui.desktop.WikipediaActiveSandboxPage;
import org.laba.carina.gui.desktop.WikipediaEditSandboxPage;
import org.laba.carina.gui.desktop.WikipediaSandboxPage;
import org.laba.carina.gui.desktop.WikipediaLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class WikipediaTestsSixToTen implements IAbstractTest {
    private static final Logger LOGGER = Logger.getLogger(WikipediaTestsSixToTen.class);
    private static final String SANDBOX_REGEX = "https://es\\.wikipedia\\.org/wiki/Wikipedia:Zona_de_pruebas(/\\d{1,2})?";
    private static final String EDIT_REGEX = "https://es\\.wikipedia\\.org/w/index\\.php\\?title=Wikipedia:Zona_de_pruebas/([1-9]|10)&action=edit";
    private static final String PREVIEW_REGEX = "https://es\\.wikipedia\\.org/w/index\\.php\\?title=Wikipedia:Zona_de_pruebas/([1-9]|10)&action=submit";
    private static final String LOGIN_REGEX = "^https://es\\.wikipedia\\.org/w/index\\.php\\?[^&]*&title=Especial:Entrar(&.*)?$";

    /**
     * Checks if a page's URL matches with a given regular expression.
     * @param page A POM that we want to validate against a regex
     * @param regex The regular expression that you want to use in the validation process
     * @return True if the page's URL matches the provided regex.
     */
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
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String text = "Something.";
        editSandboxPage.clickButtonByText("Empezar a editar");
        editSandboxPage.clickTextArea();
        editSandboxPage.typeInTextArea("Something.");
        WikipediaActiveSandboxPage activeSandboxPage = editSandboxPage.clickOnSaveButton();
        Assert.assertTrue(validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX), "Failed to get back to the active sandbox page.");
        Assert.assertTrue(activeSandboxPage.editedTextContains(text), "Failed to apply the changes to the page (Added text is not there)");
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "changes should not apply when we cancel the editing", value = {"web", "regression"})
    public void verifyEditedChangesDidNotRemainAfterCancelling(){ // Test #7
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaEditSandboxPage editSandboxPage = openActiveSandboxPage(homePage);
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String oldText = editSandboxPage.getEditingText();
        String text = "Something.";
        String newText = oldText + "\n" + text;
        editSandboxPage.clickButtonByText("Empezar a editar");
        editSandboxPage.clickTextArea();
        editSandboxPage.typeInTextArea("Something.");
        WikipediaActiveSandboxPage activeSandboxPage = editSandboxPage.clickOnSaveButton();
        Assert.assertTrue(validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX), "Failed to get back to the active sandbox page.");
        Assert.assertFalse(activeSandboxPage.editedTextEquals(newText), "Failed to abort the changes to the page (The whole edited text is there)");
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "changes should appear while previewing them", value = {"web", "regression"})
    public void verifyChangesAppearInPreview(){ // Test #8
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaEditSandboxPage editSandboxPage = openActiveSandboxPage(homePage);
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String oldText = editSandboxPage.getEditingText();
        String text = "Something.";
        String newText = oldText + "\n" + text;
        editSandboxPage.clickButtonByText("Empezar a editar");
        editSandboxPage.clickTextArea();
        editSandboxPage.typeInTextArea("Something.");
        WikipediaEditSandboxPage previewSandboxPage = editSandboxPage.clickOnPreviewButton();
        Assert.assertTrue(validatePageAgainstRegex(previewSandboxPage, PREVIEW_REGEX), "Failed to preview the changes made.");
        Assert.assertEquals(previewSandboxPage.getEditingText(), newText, "Failed to apply the changes made. (The changes do not appear in the preview)");
    }

    @Test
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "bold text should be, in fact, bold", value = {"web", "regression"})
    public void verifyBoldText(){ // Test #9
        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaEditSandboxPage editSandboxPage = openActiveSandboxPage(homePage);
        Assert.assertNotNull(editSandboxPage, "Failed to open and edit an available sandbox.");
        String text = "Something.";
        editSandboxPage.clickButtonByText("Empezar a editar");
        editSandboxPage.clickTextArea();
        editSandboxPage.typeInTextArea("Something.", TextFormat.Type.BOLD);
        WikipediaActiveSandboxPage activeSandboxPage = editSandboxPage.clickOnSaveButton();
        Assert.assertTrue(validatePageAgainstRegex(activeSandboxPage, SANDBOX_REGEX), "Failed to preview the changes made.");
        Assert.assertTrue(activeSandboxPage.editedTextIsBold(text), "Text is not bold.");
    }
    @Test()
    @MethodOwner(owner = "nicuri")
    @TestPriority(Priority.P3)
    @TestLabel(name = "captcha should pop up with repeated incorrect login attempts", value = {"web", "regression"})
    public void verifyCaptchaWorks(){ // Test #10 (data provider)
        Object[][] loginData = testDataProvider.loginDataProvider();

        OurWikipediaHomePage homePage = new OurWikipediaHomePage(getDriver());
        homePage.open();
        WikipediaLoginPage loginPage = homePage.openLoginPage();
        Assert.assertTrue(validatePageAgainstRegex(loginPage, LOGIN_REGEX), "Failed to enter to the login page");

        for (Object[] credentials : loginData) {
            String user = (String) credentials[0];
            String pass = (String) credentials[1];

            loginPage.typeOnUserField(user);
            loginPage.typeOnPasswordField(pass);
            loginPage.clickOnLoginButton();

            if (loginPage.captchaAppeared()){
                break;
            }
        }

        Assert.assertTrue(loginPage.captchaAppeared(), "Captcha did not appear");
    }
}
