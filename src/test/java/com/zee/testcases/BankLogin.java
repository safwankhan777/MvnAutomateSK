package com.zee.testcases;

import com.zee.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankLogin extends TestBase {

    @Test
    public void login () throws InterruptedException {

        driver.findElement(By.xpath(OR.getProperty("BankManagerLoginBtn"))).click();
        log.debug("user clicked successfully for bank manager login button");

        /* Reporter.log("<a target=\"_blank\" href=\"file://Users/safwankhan/Documents/Selenium_Automation/MvnAutomateSK/src/test/resources/screenshot/error.png\">View Screenshot</a>");
        Reporter.log("<img src=\"data:image/png;base64," + base64ScreenshotContent + "\" alt=\"view screenshot\">");*/

        //Thread.sleep(3000);
    }
}
