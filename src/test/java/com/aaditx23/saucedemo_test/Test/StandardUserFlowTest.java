package com.aaditx23.saucedemo_test.Test;

import com.aaditx23.saucedemo_test.DTO.LoginDto;
import com.aaditx23.saucedemo_test.POM.ProductsPage;
import com.aaditx23.saucedemo_test.Util.UserType;
import com.aaditx23.saucedemo_test.POM.LoginPage;
import com.aaditx23.saucedemo_test.Util.CsvReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class StandardUserFlowTest {

    private WebDriver driver;
    private Map<UserType, LoginDto> data;

    @BeforeEach
    public void setup(){
        driver = new FirefoxDriver();
        data = CsvReader.getCsvData();
    }

    @Test
    public void standardUserFlow(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(data.get(UserType.STANDARD));
        Assertions.assertFalse(loginPage.hasError());

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart();
        productsPage.removeFromCart();
    }

//    @AfterEach
//    public void teardown(){
//        driver.quit();
//    }
}
