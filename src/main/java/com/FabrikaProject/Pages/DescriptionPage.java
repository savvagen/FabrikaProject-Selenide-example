package com.FabrikaProject.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class DescriptionPage {

    public static final String DESCRIPTION_PAGE_URL = baseUrl + "/default/privacy";
    public static final String descriptionTitle = "Для чего нам это???";


    public SelenideElement descriptionTitleField = $(By.tagName("h2"));

    public DescriptionPage openaPage(){
        open(DESCRIPTION_PAGE_URL);
        return this;
    }

}
