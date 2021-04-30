package com.myapp.selenium;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GoogleSearchTest {
    public WebDriver driver;


    @BeforeMethod
	@BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestsDriver setupTestDriver = new SetupTestsDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }


    @Test
    public void googleTitleTest() {
        // validate page title test
        AssertJUnit.assertTrue(driver.getTitle().contentEquals("Google"));
    }


    @Test
    public void googleUrlTest() {
        // validate current url test
        AssertJUnit.assertTrue(driver.getCurrentUrl().contains("www.google.com"));
    }


    @Test
    public void googleSearchButtonTest() {
        // basic test to validate that search button is displayed, enabled and it's value
        WebElement searchButtonElement = driver.findElement(By.name("btnK"));
//        Assert.assertTrue(searchButtonElement.isDisplayed());
//        Assert.assertTrue(searchButtonElement.isEnabled());
        AssertJUnit.assertTrue(searchButtonElement.getAttribute("value").contains("Google Search"));
    }


    @Test
    public void googleFeelingLuckyButtonTest() {
        // basic test to validate that feeling lucky button is displayed, enabled and it's value
        WebElement feelingLuckyElement = driver.findElement(By.name("btnI"));
        AssertJUnit.assertTrue(feelingLuckyElement.isDisplayed());
        AssertJUnit.assertTrue(feelingLuckyElement.isEnabled());
        AssertJUnit.assertTrue(feelingLuckyElement.getAttribute("value").contains("I'm Feeling Lucky"));
    }


    @Test
    public void googleSearchBox() {
        // basic test to validate that search box displayed and enabled
        WebElement searchElement = driver.findElement(By.name("q"));
        AssertJUnit.assertTrue(searchElement.isDisplayed());
        AssertJUnit.assertTrue(searchElement.isEnabled());
    }






    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }


}

