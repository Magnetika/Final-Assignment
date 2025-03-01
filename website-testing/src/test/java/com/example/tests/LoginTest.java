package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.homemate.com.mt/homemate-login");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCorrectCredentials() {
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtEmail")).sendKeys("agneslilla.szabo@gmail.com");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtPassword")).sendKeys("vEeM7!YbNbQ8gLH");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_btnLogin")).click();
    }

    @Test
    public void testMissingUsername() {
    	driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtPassword")).sendKeys("vEeM7!YbNbQ8gLH");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_btnLogin")).click();
        WebElement error = driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_rfvEmail"));
        assertEquals("Email is required", error.getText());
    }

    @Test
    public void testMissingPassword() {
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtEmail")).sendKeys("agneslilla.szabo@gmail.com");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_btnLogin")).click();
        WebElement error = driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_rfvPassword"));
        assertEquals("Password is required", error.getText());
    }

    @Test
    public void testIncorrectCredentials() {
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtEmail")).sendKeys("agneslilla.szabo@gmail.com");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_btnLogin")).click();
        WebElement error = driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_lblWrongLogin"));
        assertEquals("Login/Password is Incorrect", error.getText());
    }

    @Test
    public void testLogout() {
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtEmail")).sendKeys("agneslilla.szabo@gmail.com");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_txtPassword")).sendKeys("vEeM7!YbNbQ8gLH");
        driver.findElement(By.id("ctl00_PageContent_ContentControl_ctl00_btnLogin")).click();
        driver.findElement(By.className("homemate-login")).click();
        WebElement loginPage = driver.findElement(By.id("SubmitLogin"));
      
    }
}

