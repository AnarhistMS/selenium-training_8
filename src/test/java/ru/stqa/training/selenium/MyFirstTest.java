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
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(titleIs("Online Store | My Store"));
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
        for(WebElement e : products) {
            Assert.assertEquals(1, e.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size());
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver= null;
    }
}