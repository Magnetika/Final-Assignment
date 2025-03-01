package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.homemate.com.mt/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCommonSearchTerm() {
        driver.findElement(By.id("search_query_top")).sendKeys("desk");
        driver.findElement(By.name("submit_search")).click();
        WebElement results = driver.findElement(By.className("product_list"));
        assertTrue(results.isDisplayed());
    }

    @Test
    public void testLessCommonSearchTerm() {
        driver.findElement(By.id("search_query_top")).sendKeys("office desk");
        driver.findElement(By.name("submit_search")).click();
        WebElement results = driver.findElement(By.className("product_list"));
        assertTrue(results.isDisplayed());
    }

    @Test
    public void testMultipleSearchTerms() {
        driver.findElement(By.id("search_query_top")).sendKeys("desk, chairs");
        driver.findElement(By.name("submit_search")).click();
        WebElement results = driver.findElement(By.className("product_list"));
        assertTrue(results.isDisplayed());
    }

    @Test
    public void testUnlikelySearchTerm() {
        driver.findElement(By.id("search_query_top")).sendKeys("unlikely term");
        driver.findElement(By.name("submit_search")).click();
        WebElement noResults = driver.findElement(By.xpath("//p[contains(text(), 'No results were found for your search')]"));
        assertTrue(noResults.isDisplayed());
    }

    @Test
    public void testNoSearchTerm() {
        driver.findElement(By.name("submit_search")).click();
        WebElement noResults = driver.findElement(By.xpath("//p[contains(text(), 'Please enter a search keyword')]"));
        assertTrue(noResults.isDisplayed());
    }
}

