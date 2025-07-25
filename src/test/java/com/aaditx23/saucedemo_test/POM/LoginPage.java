package com.aaditx23.saucedemo_test.POM;

import com.aaditx23.saucedemo_test.DTO.LoginDto;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        driver.get(homeUrl());
    }

    By userNameField = By.cssSelector("input#user-name");
    By passwordField = By.cssSelector("input#password");
    By loginButton = By.cssSelector("input#login-button");
    By errorContainer = By.cssSelector("div.error-message-container.error");

    private void enterUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
    }
    private void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    private void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void login(LoginDto loginDto){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        enterUserName(loginDto.getUsername());
        enterPassword(loginDto.getPassword());
        clickLogin();
    }

    public Boolean hasError(){
        try{
            driver.findElement(errorContainer);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
}
