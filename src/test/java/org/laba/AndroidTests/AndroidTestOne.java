package org.laba.AndroidTests;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.carina.demo.mobile.gui.pages.android.ChartsPage;
import org.example.carina.demo.mobile.gui.pages.android.WebViewPage;
import org.example.carina.demo.mobile.gui.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTestOne implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testOne(){
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");

        WebViewPageBase webViewPage= initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isPageOpened(), "Web view page isn't opened");

        webViewPage.goToChartsPage();
        ChartsPage chartsPage=initPage(getDriver(),ChartsPage.class);
        Assert.assertTrue(chartsPage.isPageOpened(), "Charts page isn't opened");
        chartsPage.cycleView();
    }
}
