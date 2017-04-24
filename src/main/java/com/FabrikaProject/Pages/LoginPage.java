package com.FabrikaProject.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = baseUrl + "/default/user/login";
    public String user_email = "savva.genchevskiy@gmail.com";
    public String user_password = "19021992qa";

    public SelenideElement emailField = $(byName("email")),
            passwordField = $(byName("password")),
            submitButton = $(byText("Login"));

    public LoginPage openPage(){
        open(LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage login(String email, String password){
        emailField.shouldBe(Condition.visible).setValue(email);
        passwordField.setValue(password).pressEnter();
        //submitButton.click();
        return this;
    }






}
