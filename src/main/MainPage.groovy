package main

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class MainPage extends Page{

    def baseURL = "http://webdriver.io"
    def apiLinkCSS = "[href=\"/api.html\"]"
    def robotImageCSS = "[src=\"/images/webdriverio.png\"]"


    MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait)
    }

    def visitMainPage(){
        driver.get(baseURL)
    }

    def transitionToAPIPage(){
        click(By.cssSelector(apiLinkCSS))
        APIPage apiPage = new APIPage(driver, wait)
        apiPage.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(apiPage.improveDocButtonCSS)))
    }
}
