package com.zee.utlities;

import com.zee.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

public class TestUtil extends TestBase {

    public  static  String screenshotPath;
    public  static  String screenshotName;


    public static void captureScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName = "error";
        String targetPath = System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName + ".jpg";
        File targetFile = new File(targetPath);
        FileUtils.copyFile(srcFile, targetFile);
        //FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName+".jpg"));
    }

}
