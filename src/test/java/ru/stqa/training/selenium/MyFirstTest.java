package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/");
        wait.until(titleIs("Online Store | My Store"));
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
        for(WebElement e : products) {
            Assert.assertFalse(e.findElements(By.xpath(".//li[contains(@class, 'sticker')]")).size() == 1);
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver= null;
    }
}