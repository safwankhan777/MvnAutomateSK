package com.zee.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.apache.log4j.Logger.getLogger;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    //public static org.apache.log4j.Logger log = getLogger();
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static FileInputStream fis;


    @BeforeTest
    public void setup() throws IOException {
        if (driver==null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
            config.load(fis);
            log.debug("config file loaded");
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
            OR.load(fis);
            log.debug("OR- Object repository file loaded");
            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                log.debug("Chrome brwoser was launched");
            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                log.debug("Firefox brwoser was launched");
            } else {
                driver = new SafariDriver();
                log.debug("brwoser Safari was invoked");
            }

            driver.manage().window().maximize();
            log.debug("URL launched successfully");
            driver.get(config.getProperty("testurl"));
            Reporter.log("URl launch successfully");
        }

    }

    @AfterTest
    public void teardown(){
        if (driver!=null) {
            driver.close();
            driver = null;
            log.debug("Browser closed ");
        }
    }


}
