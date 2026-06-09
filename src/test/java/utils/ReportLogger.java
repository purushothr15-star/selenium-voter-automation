package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import listeners.TestListener;

import java.io.File;


public class ReportLogger {

    //static ScreenShotUtils su = new ScreenShotUtils();
    public static ExtentTest test;

    public static void log(String logText, String info, String value){
        String path =
                ScreenShotUtils.captrueScreenShot(
                        BaseTest.driver,
                        logText
                );
        try{
            File file = new File(path);
            ReportLogger.test.info(
                    logText + value
            ).addScreenCaptureFromPath(file.getAbsolutePath());

        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
