package com.FabrikaProject.Pages.HomePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selenide.$$;



public class PostTable {

    public ElementsCollection posts = $$(".web2py_htmltable table tbody tr");


    public PostTable shouldHaveSize(int size){
        posts.shouldHaveSize(size);
        return this;
    }

    public PostTable shouldHaveMessage(int index, String message){
        /*posts.last().shouldHave(Condition.text(message));*/
        posts.get(index).shouldHave(Condition.text(message));
        return this;
    }
    public PostTable shouldHaveUserId(int index, String user){
        /*posts.last().find(byXpath("//td[2]")).shouldHave(Condition.text(user));*/
        posts.get(index).find(byXpath("//td[2]")).shouldHave(Condition.text(user));
        return this;
    }

    public PostTable shouldNotHaveMessage(String message){
        posts.last().$(byXpath("//td[2]")).shouldNotHave(Condition.text(message));
        return this;
    }




}
