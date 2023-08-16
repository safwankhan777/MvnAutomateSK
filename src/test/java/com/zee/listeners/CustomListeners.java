package com.zee.listeners;

import com.zee.base.TestBase;
import com.zee.utlities.TestUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners implements ITestListener {

    public void  onTestStart(ITestResult result){

    }

    public  void  onTestSuccess(ITestResult result){

    }

    public void  onTestFailure(ITestResult result){
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Reporter.log("capturing screenshots");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">View Screenshot</a>");
        //Reporter.log("<a target=\"_blank\" href=\"http://localhost:8000/error.png\n\">View Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width = 200></img></a>");

    }

    public void  onStart(ITestResult result){

    }

    public void  onFinish(ITestResult result){

    }
}
