package com.FabrikaProject.Pages;

import com.FabrikaProject.Pages.HomePage.HomePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.*;

public class SuccessDeletingPage {

    public String deletedMessage = "User DELETED!" + "\n" + " × ";

    public SelenideElement homeButton = $(byText("Home")),
                        flashBoard = $(byClassName("flash"));

    public HomePage pressHome(){
        homeButton.click();
        return new HomePage();
    }



}
