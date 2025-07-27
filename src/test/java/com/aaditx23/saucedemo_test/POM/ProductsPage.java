package com.aaditx23.saucedemo_test.POM;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver){
        super(driver);
        waitForPage("products");

    }

    Random random = new Random();
    By addToCartButtons = By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory");
    By removeButtons = By.cssSelector("button.btn.btn_secondary.btn_small.btn_inventory");
    By shoppingCartLink = By.cssSelector("a.shopping_cart_link");

    public void addToCart(){
        randomlyClickButtons(addToCartButtons);
    }

    public void removeFromCart(){
        randomlyClickButtons(removeButtons);

    }

    private int generateRandomTimes(By locator){
        int bound = driver.findElements(locator).size();
        int times = random.nextInt((locator == addToCartButtons)? bound/2 : 0, bound );
        if (locator == removeButtons && times == 0) return 1;
        else return times;
    }

    private void randomlyClickButtons(By locator){
        int times = generateRandomTimes(locator);
        for(int i = 0; i<times; i++){
            List<WebElement> buttons = driver.findElements(locator);
            if(buttons.isEmpty()) break;
            int index = random.nextInt(buttons.size());
            WebElement button = buttons.get(index);
            try{
                if(button.isDisplayed()) button.click();
            }
            catch (StaleElementReferenceException e){
                System.out.println("Skipping stale element");
                i++;
            }
        }
    }

    public void goToCart(){
        driver.findElement(shoppingCartLink).click();
    }




}
