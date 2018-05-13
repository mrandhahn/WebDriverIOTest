package main

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class APIPage extends Page{

    def improveDocButtonCSS = ".btn.icon-edit.improve"
    def inPageSearchBarCSS = "[name=\"search\"]"
    def searchBarXButtonCSS = ".icon.icon-remove"

    def clickActionLinkCSS = ".commands.action.active a[href*='click.html']"
    def doubleClickActionLinkCSS = ".commands.action.active a[href*='doubleClick.html']"
    def leftClickActionLinkCSS = ".commands.action.active a[href*='leftClick.html']"
    def middleClickActionLinkCSS = ".commands.action.active a[href*='middleClick.html']"
    def rightClickActionLinkCSS = ".commands.action.active a[href*='rightClick.html']"


    APIPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait)
    }

    def searchInPage(String text){
        sendText(By.cssSelector(inPageSearchBarCSS), text)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchBarXButtonCSS)))
    }

    def clickActionLinkIsDisplayed(){
        driver.findElement(By.cssSelector(clickActionLinkCSS)).isDisplayed()
    }

    def doubleClickActionLinkIsDisplayed(){
        driver.findElement(By.cssSelector(doubleClickActionLinkCSS)).isDisplayed()
    }

    def leftClickActionLinkIsDisplayed(){
        driver.findElement(By.cssSelector(leftClickActionLinkCSS)).isDisplayed()
    }

    def middleClickActionLinkIsDisplayed(){
        driver.findElement(By.cssSelector(middleClickActionLinkCSS)).isDisplayed()
    }

    def rightClickActionLinkIsDisplayed(){
        driver.findElement(By.cssSelector(rightClickActionLinkCSS)).isDisplayed()
    }

    def readFromSearchBar(){
        driver.findElement(By.cssSelector(inPageSearchBarCSS)).getAttribute("value")
    }

    def clearSearchData(){
        click(By.cssSelector(searchBarXButtonCSS))
    }
}
