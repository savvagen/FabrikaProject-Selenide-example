package com.FabrikaProject.Pages;



import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.*;


public class RegistrationPage {

    public static final String REGISTER_PAGE_URL = baseUrl + "/default/user/register";

    public String firstName = "Savva";
    public String secondName = "Genchevskiy";
    public String email = "savva.genchevskiy+1@gmail.com";
    public String password = "19021992qa";
    public String nickName = "savva_gench";


    public SelenideElement firstNameField = $(byId("auth_user_first_name")),
                lastNameField = $(byId("auth_user_last_name")),
                emailField = $(byId("auth_user_email")),
                passwordField = $(byId("auth_user_password")),
                secondPasswordField = $(byName("password_two")),
                nickNameField = $(byId("auth_user_nickname")),
                imageField = $(byId("auth_user_image")),
                submitButton = $(byXpath("//*/input[@value='Register']")),
                errorMessageField = $(byClassName("error")),
                emailError = $(byId("email__error")),
                passwordMatchError = $("password_two__error"),
                passwordError = $("password__error");


    public RegistrationPage openPage(){
        open(REGISTER_PAGE_URL);
        return this;
    }

    public RegistrationPage register(String firstName, String lastName,String email, String password, String nickName){
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        emailField.setValue(email);
        passwordField.setValue(password);
        secondPasswordField.setValue(password);
        nickNameField.setValue(nickName);
        submitButton.click();
        return this;
    }


    public RegistrationPage invalidRegistration(String firstName, String lastName, String email,
                                                String password, String confirmPassword,
                                                String nickName){
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        emailField.setValue(email);
        passwordField.setValue(password);
        secondPasswordField.setValue(confirmPassword);
        nickNameField.setValue(nickName);
        submitButton.click();
        errorMessageField.shouldBe(visible);
        return this;
    }

    public RegistrationPage registerTestUser(){
        firstNameField.setValue(firstName);
        lastNameField.setValue(secondName);
        emailField.setValue(email);
        passwordField.setValue(password);
        secondPasswordField.setValue(password);
        nickNameField.setValue(nickName);
        submitButton.click();
        return this;
    }













}
