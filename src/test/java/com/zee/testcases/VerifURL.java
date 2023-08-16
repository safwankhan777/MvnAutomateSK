package com.zee.testcases;

import com.zee.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifURL extends TestBase {

    @Test(enabled = true)
    public  void titleURL() throws InterruptedException {

        String exptitle = "Protractor practice website - Banking App";
        String title= driver.getTitle();
        Assert.assertEquals(exptitle,title);

        /*driver.findElement(By.xpath(OR.getProperty("BankManagerLoginBtn"))).click();
        log.debug("clicked bank manager done!!");
        Thread.sleep(1500);
        String extitle = "Protractor practice website - Banking App";
        String title= driver.getTitle();
        Assert.assertEquals(extitle,title);
        String EXurl = "https://www.way2automation.com/angularjs-protractor/banking/#/manager1";
        String theUrl = driver.getCurrentUrl();
        Assert.assertEquals(theUrl,EXurl);*/

    }

    @Test(enabled = false)
    public void CheckButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
      //  driver.findElement(By.xpath(OR.getProperty("BankManagerLoginBtn"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath(OR.getProperty("AddcustTab"))).click();
        Thread.sleep(1500);
        WebElement bankbutton = driver.findElement(By.xpath(OR.getProperty("BankManagerLoginBtn")));
        Assert.assertFalse(bankbutton.isDisplayed());

        /*WebElement AddCust = driver.findElement(By.xpath(OR.getProperty("AddCustomerLast")));
        Assert.assertTrue(bankbutton.isDisplayed());*/
    }

}
