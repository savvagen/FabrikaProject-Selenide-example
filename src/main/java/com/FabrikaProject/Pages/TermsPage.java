package com.FabrikaProject.Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class TermsPage {

    public static final String TERMS_PAGE_URL = baseUrl + "/default/terms";
    public static final String courseDurationMessage = "Длительность курса ~ 26 пар по 2 часа. 3 месяца на курс.";

    public SelenideElement courseDurationField = $(By.tagName("h2"));


    public TermsPage openPage(){
        open(TERMS_PAGE_URL);
        return this;
    }

}
