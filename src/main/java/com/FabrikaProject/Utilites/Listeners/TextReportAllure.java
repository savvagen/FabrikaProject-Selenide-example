package com.FabrikaProject.Utilites.Listeners;

import com.FabrikaProject.Utilites.CustomReport;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;
import ru.yandex.qatools.allure.Allure;



public class TextReportAllure extends ExitCodeListener {

    CustomReport report = new CustomReport();


    @Override
    public void onTestStart(ITestResult testResult){
        report.start();

    }



    @Override
    public void onTestFailure(ITestResult testResult){
        report.finish(testResult.getName());


    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        report.finish(testResult.getName());
    }




}
