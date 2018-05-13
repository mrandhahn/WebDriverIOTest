package main

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

class Page {
    def driver
    def wait

    def Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver
        this.wait = wait
    }

    void click(By locator){
        driver.findElement(locator).click()
    }

    void sendText(By locator, String text){
        driver.findElement(locator).sendKeys(text)
    }

    def readText(By locator){
        driver.findElement(locator).getText()
    }
}
