package com.aaditx23.saucedemo_test.POM;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitForPage(String pageTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        Assertions.assertTrue(
                (driver.findElement(title).getText().equalsIgnoreCase(pageTitle)),
                "Wrong page: "+pageTitle
        );
    }

    By title = By.cssSelector("div.header_secondary_container > span.title");

    public String homeUrl(){
        return "https://www.saucedemo.com/";
    }
}
