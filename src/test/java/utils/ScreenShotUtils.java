package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtils {
    public static String captrueScreenShot(WebDriver driver, String screenshotName){
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String path = "screenshots/" + screenshotName+"_"+timeStamp+".png";

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            try{
                FileUtils.copyFile(src, dest );

            }
            catch (IOException e){
                e.printStackTrace();
            }
        return path;
    }

}
