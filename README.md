# Changelog
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