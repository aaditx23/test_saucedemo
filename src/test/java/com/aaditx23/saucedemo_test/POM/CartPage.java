package com.aaditx23.saucedemo_test.POM;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
        waitForPage("your cart");
    }


    By checkoutButton = By.cssSelector("button#checkout");

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }


}
