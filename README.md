# TO-DO:

- Test 8º: 
	- Purpose: Changes are reflected in the preview of the page
	- Same steps as above, this time, when we click on the available sandbox:
	- Edit the text with anything, then click on preview changes and assert that the changes we made are reflected in the preview.
- Test 9º: 
	- Purpose: BOLD text is in fact bold when previewed and applied.
	- Same steps as above, this time, when we click on the available sandbox:
	- Edit the page, adding some BOLD text.
	- First, preview changes and assert that the added text is in fact bold.
	- Lastly, apply the changes and assert again that the added text remained bold.
- Test 10º: The data provider one; 
	- Purpose: Check that captcha is working as intended.
	- Enter to the log in page
	- Make a counter variable starting in zero.
	- Make a WHILE loop that iterates n times, being n the amount of data we have in our log in data set, OR until a certain web element appears.
	- In each iteration of the for loop we will input the data, click on log in and one up the counter variable.
	- If the captcha appears (whether we managed to input the entire dataset or not) we will assert that the counter variable is less than n (the quantity of unique data in our data set) AND that the captcha appeared.

# Changelog
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