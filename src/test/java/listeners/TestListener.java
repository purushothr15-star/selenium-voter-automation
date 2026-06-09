package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ReportLogger;
import utils.ScreenShotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result){
        ReportLogger.test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ReportLogger.test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        ReportLogger.test.fail(result.getThrowable());

        String path = ScreenShotUtils.captrueScreenShot(base.BaseTest.driver, result.getMethod().getMethodName());

        try{
            ReportLogger.test.addScreenCaptureFromPath(path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }



}
