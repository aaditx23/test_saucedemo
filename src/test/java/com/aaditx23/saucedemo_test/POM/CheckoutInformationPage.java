package com.aaditx23.saucedemo_test.POM;

import com.aaditx23.saucedemo_test.DTO.UserInfoDto;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends BasePage{

    public CheckoutInformationPage(WebDriver driver){
        super(driver);
        waitForPage("Checkout: Your Information");
    }

    By firstNameField = By.cssSelector("input#first-name");
    By lastNameField = By.cssSelector("input#last-name");
    By postalCodeField = By.cssSelector("input#postal-code");
    By continueButton = By.cssSelector("input#continue");

    private void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    private void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    private void enterPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void enterInformation(UserInfoDto info){
        enterFirstName(info.getFirstName());
        enterLastName(info.getLastName());
        enterPostalCode(info.getZipCode());
        driver.findElement(continueButton).click();
    }



}
