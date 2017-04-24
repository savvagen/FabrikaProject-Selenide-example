package com.FabrikaProject.Utilites;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Helpers {

    @Attachment
    public static byte[] tackeScreenshot(){
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Test log")
    public static String attacheText(String text){
        return text;
    }

    


}
