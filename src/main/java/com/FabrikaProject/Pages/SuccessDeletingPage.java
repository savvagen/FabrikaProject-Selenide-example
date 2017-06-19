package com.FabrikaProject.Pages;

import com.FabrikaProject.Pages.HomePage.HomePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class SuccessDeletingPage {

    public String deletedMessage = "User DELETED!" + "\n" + " × ";

    public SelenideElement homeButton = $(byText("Home")),
                        flashBoard = $(byClassName("flash"));

    public HomePage pressHome(){
        homeButton.click();
        return new HomePage();
    }



}
