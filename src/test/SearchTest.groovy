package test

import main.APIPage
import main.MainPage
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.*

class SearchTest {

    def driver
    def wait

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maxra\\IdeaProjects\\WebDriverIOTest\\src\\chromedriver.exe")
        driver = new ChromeDriver()

        wait = new WebDriverWait(driver, 15)

        driver.manage().window().maximize()
    }

    @AfterClass
    void tearDown() {
        driver.quit()
    }

    @Test
    void searchForAPILinksTest() {
        MainPage mainPage = new MainPage(driver, wait)

        mainPage.visitMainPage()

        mainPage.transitionToAPIPage()

        APIPage apiPage = new APIPage(driver, wait)
        apiPage.searchInPage("click")

        Assert.assertTrue(apiPage.clickActionLinkIsDisplayed(), "Click link was not displayed")
        Assert.assertTrue(apiPage.doubleClickActionLinkIsDisplayed(), "Double click link was not displayed")
        Assert.assertTrue(apiPage.leftClickActionLinkIsDisplayed(), "Left click link was not displayed")
        Assert.assertTrue(apiPage.middleClickActionLinkIsDisplayed(), "Middle click link was not displayed")
        Assert.assertTrue(apiPage.rightClickActionLinkIsDisplayed(), "Right click link was not displayed")
    }

    @Test
    void searchBarXButtonClearsDataTest(){
        MainPage mainPage = new MainPage(driver, wait)

        mainPage.visitMainPage()

        mainPage.transitionToAPIPage()

        APIPage apiPage = new APIPage(driver, wait)
        apiPage.searchInPage("click")

        Assert.assertEquals(apiPage.readFromSearchBar(), "click")

        apiPage.clearSearchData()

        Assert.assertEquals(apiPage.readFromSearchBar(), "")
    }

    @Test
    void searchBarStartsEmptyTest(){
        MainPage mainPage = new MainPage(driver, wait)

        mainPage.visitMainPage()

        mainPage.transitionToAPIPage()

        APIPage apiPage = new APIPage(driver, wait)
        Assert.assertEquals(apiPage.readFromSearchBar(), "")
    }
}
