package com.FabrikaProject.Utilites.Listeners;



import com.FabrikaProject.Utilites.Helpers;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestNG.ExitCodeListener;



public class TestListener extends ExitCodeListener {

    //Logger log = Logger.getLogger(getClass().getName());
    //public static final Logger logger = Logger.getLogger(TestListener.class);
    private static final Logger log= Logger.getLogger("appLogger");


    @Override
    public void onTestStart(ITestResult testResult){
        super.onTestStart(testResult);
        log.info("\"" + testResult.getMethod().getMethodName() + "\"" + " test started________");
    }


    @Override
    public void onTestFailure(ITestResult testResult){
        super.onTestFailure(testResult);
        Helpers.tackeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        super.onTestSuccess(testResult);
        log.info("\"" + testResult.getMethod().getMethodName() + "\"" + " test finished with success________");
    }








}
