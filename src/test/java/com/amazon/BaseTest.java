package com.amazon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.BrowserFactory;
import utils.CommonUtils;

import java.io.IOException;


public class BaseTest extends BasePage {

    static WebDriver driver;

    BasePage basePage = new BasePage();


    @BeforeClass
    public static void setUp() {
        BrowserFactory.openBrowser();
        driver = BrowserFactory.getDriver();

    }


    @AfterClass

    public static void tearDown()  {


        BrowserFactory.stopBrowser();
    }


}
