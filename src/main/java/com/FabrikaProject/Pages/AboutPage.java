package com.FabrikaProject.Pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class AboutPage {

    public static final String ABOUT_PAGE_URL = baseUrl + "/default/about";

    public String courseTitle = "Описание курса:";
    public String courseDescription = "В курсе рассматриваются основные теоретические и практические моменты автоматизации тестирования программного обеспечения: отличие мануального тестирования от автоматического, когда стоит применять автоматическое тестирование, основные инструменты автоматизации (Selenium, QTP и другие), репортинг, разработка автоматических тестов, анализ автоматических тестов, написание скриптов для включения в автоматические тесты и так далее. После каждой теоретической части проводится практическое занятие, позволяющее закрепить полученные знания. Курс ориентирован на развитие у слушателей навыков автоматизации тестирования программного обеспечения, понимания инструментов автоматизации, прогнозирование возможных проблем, репортинг и анализ результатов.";

    public SelenideElement courseTitileField = $(By.xpath("//*/section[@id='main']/h1")),
                    courseDescriptionField = $(byXpath("//*/section[@id='main']/p"));



    public AboutPage openaPage(){
        open(ABOUT_PAGE_URL);
        return this;
    }


}
