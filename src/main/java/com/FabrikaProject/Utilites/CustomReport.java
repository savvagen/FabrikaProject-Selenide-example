package com.FabrikaProject.Utilites;

import com.codeborne.selenide.logevents.EventsCollector;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.logevents.SimpleReport;
import com.google.common.base.Joiner;
import com.sun.glass.ui.EventLoop;
import org.apache.log4j.Logger;

import java.util.Collections;


public class CustomReport extends SimpleReport {

    //private static final Logger log = Logger.getLogger(SimpleReport.class.getName());
    private static final Logger log= Logger.getLogger("appLogger");

    private EventsCollector logEventListener;


    public void start(){
        SelenideLogger.addListener("AllureListener",  logEventListener = new EventsCollector());
    }

    public void finish(String title){
        SelenideLogger.removeListener("AllureListener");

        StringBuilder sb = new StringBuilder();
        sb.append("Report for ").append(title).append("\n");
        String delimeter = "+" + Joiner.on("+").join(line(20), line(70), line(10), line(10) + "+\n");
        sb.append(delimeter);
        sb.append(String.format("|%-20s|%-70s|%-10s|%-10s|%n", "Element", "Subject", "Status", "ms."));
        sb.append(delimeter);

        for (LogEvent e: logEventListener.events() ){
            sb.append(String.format("|%-20s|%-70s|%-10s|%-10s|%n", e.getElement(), e.getSubject(), e.getStatus(), e.getDuration()));
        }
        sb.append(delimeter);
        log.info(sb.toString());
        Helpers.attacheText(sb.toString());
    }



    private String line(int count){ return Joiner.on("").join(Collections.nCopies(count, "-")); }





}
