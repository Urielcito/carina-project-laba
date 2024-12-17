# Changelog

## 17/12/2024 4:18 AM
* Added some Abstract UI Objects to facilitate test development (Numpad, unit container) 
	- Note for @NicolasChas: Check it out, you should be able to just delete the methods you made in appMain and use the numPad's methods for handling inputs (I didn't account for the 'advanced' section of the calculator still, as it's just adding the locators for it anyways.) Also I check out my approach for entering numbers and retrieving them from a result field =D.
* Finished Android Native Tests
* Added the sixth test:
	- Purpose: The math for converting lengths is correct
* Added the seventh test:
	- Purpose: The math for converting masses is correct
* Added the eigth test:
	- Purpose: The math for convertir areas is correct
* Added the nineth test:
	- Purpose: An operation is reflected in the history of the app
* Added the tenth test:
	- Purpose: An operation is no longer reflected in the history after deleting the entire history of the app.


## 12/12/2024 15:15 PM
* Finished First Five tests.
* -First test does 4 random one digit sums.
* -Second does one random 4 digit sum.
* -Third Tests if the value of the irrational number e is correct in the app.
* -Fourth tests if the app follows the rule of minus times minus = positive.
* -Fifth tests if the app follows the rule of (a+b)2 = a2+2ab+b2.

## 09/12/2024 18:28 PM
* Developed a default test that executes an apk and asserts that it's opened.
* Note for @NicolasChas: In the test (AndroidDriverTest.java in package org.laba), the user should be provided by the _config.properties file under the Android section with the name 'PC-user'. From now on we are including this file in the .gitignore so that further development does not expose vulnerable information to the internet. To make this work you only have to make a new line and type 'PC-user={your_user}' somewhere in the _config.properties file.
* Current problem: appium had a hard time gathering the automatically-downloaded apk from MY PC (temp files) just by passing the url for it (I don't know if this would be the case in your PC, if you wanna try, the url is as follows: https://dw.uptodown.net/dwn/TUJMBZW_Zv7ykK0CxXAOdeF4lDvZ6_7T356fCAznDSEaAEC923XpTaGb5qGE2C-HbfHBo_sPHfaJtjJDX3gpRJHHqg0ly3J3gMA1B0xKEZg3bbpldRw9MFVEHge-6Th1/7Pqy71g0I4GTkC7M7Q1bfYaeFdOL5rj3CdjKau1-roVOcwsKdfnZqJUPhPuhNIfbvMzT0sg9MiTcaxWyn_gxUdXMDq47oT-qpVkO8w6pA-ppOixVeLDhgzO99jiJ8kiL/_21_yyVvW9zrOtopmLh-T0NWK3bbvyHRpcnGlojHrbde5xRGx9RsmminNlxYsUEYrspl-tdMptr-PlQ-I_Pjzw==/mi-calculator-15-2-11.apk).

## 09/12/2024 17:36 PM
* Succesfully connected the code with the android emulator.
## 08/12/2024 1:16 AM
* Added the needed dataprovider for my tenth test.
* Added the eighth test:
	- Purpose: Changes are reflected in the preview of the page
	- Same steps as above, this time, when we click on the available sandbox:
	- Edit the text with anything, then click on preview changes and assert that the changes we made are reflected in the preview.
* Added the nineth test:
	- Purpose: BOLD text is in fact bold when previewed and applied.
	- Same steps as above, this time, when we click on the available sandbox:
	- Edit the page, adding some BOLD text.
	- First, preview changes and assert that the added text is in fact bold.
	- Lastly, apply the changes and assert again that the added text remained bold.
* Added the tenth test:
	- Purpose: Check that captcha is working as intended.
	- Enter to the log in page
	- Iterate the data provider's data and make a login attempt for each combination of user & password
	- If the captcha appears (whether we managed to input the entire dataset or not) we will assert it's presence.
## 06/12/2024 23:33 PM
* Fixed the searching-in-the-search-bar method "search" in class ourWikipediaHomePage and its related locators, it now properly searches and enters to the desired page.
* Added another search method to exclusively search for the Sandbox page just to not modify Nico's search method *too* much.
	- Note: @NicolasChas here you should see if you want to keep the search method or just make a method to just enter to the first result like I did.
		- Extra Note: I mean, we are not doing any "checks if the results all contain the searched word" as far as I'm concerned (for the result page to be needed)
* Added the sixth test:
	- Purpose: To check that the page contents change when we apply our edit.
	- Search "Wikipedia:Sandbox" and press enter on the search bar
	- Get the list of each sandbox and see which is available first for us to edit
	- Enter to the desired sandbox, and edit the page: Copy all the text that's in the page, and add something at the end of it.
	- Save the edited text, then go back to the page and assert that the text of the page and the one we submitted are equal.
* Added the seventh test:
	- Purpose: To check that the page contents do NOT change when we DON'T apply our edit.
	- Edit the text with anything, then cancel the editing session through the "Cancel" button and assert that the changes were not applied.
	
## 06/12/24 9:29 AM
* Removed the HomePageBase pageFactory feature in web automation tests.
* Removed the unnecesary GetDriver() calls in the "GoTo" methods.
* Added the reports folder in the .gitignore, let's see if it works.
## 06/12/24 2:15 AM
* Finished first 5 tests, one with data provider which still cant hit the search button.
## 03/12/24 8:25 AM
* Succesfully ran new tests, some dont work as wanted.
## 29/11/24 4:02 AM
* API Test succesfully runs. API used is Weatherstack.
* A test that goes through three different pages is done:
	- It starts in Wikipedia Home Page, asserts that the page is indeed opened.
	- Then goes to the Sign Up Page, asserts that the page is indeed opened.
	- Finally goes to a link from a text that goes to a page about username politics, and asserts that the page was indeed opened.
* The three different POMs are:
	- OurWikipediaHomePage (has a locator with an id to open the sign up page)
	- WikipediaSignUpPage (has a locator with an xpath for the usernames web page link)
	- WikipediaUsernamesPage (has no locators (end page))
## 26/11/24 11:28 AM
* Wikipedia page now opens
## 26/11/24 0:31 AM
* I generated the mvn archetype for the RELEASE version but somehow got the DEMO one. Atleast this works not like the previous one. (Everything was left untouched)
## 25/11/24 12:33 PM
* I added the files from the carina repository (not the demo)
* I don't know if it works already but this is the starting point