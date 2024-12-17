/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laba;



import org.laba.carina.mobile.gui.pages.android.CalculatorAppMain;
import org.testng.Assert;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

public class AndroidDriverTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "nicuri")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void driverTest() {
        String user = R.CONFIG.get("PC-user");
        R.CONFIG.put("capabilities.app", "D:\\Program Files (x86)\\Android\\app.apk", true);
        CalculatorAppMain appMain = new CalculatorAppMain(getDriver());
        appMain.clickOnDontAgree();
        Assert.assertTrue(appMain.isOpened());
    }
}