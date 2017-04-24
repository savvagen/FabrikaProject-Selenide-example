package com.FabrikaProject.Pages;

import com.FabrikaProject.Pages.HomePage.PostTable;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class PostMessagePage {

    public static final String POST_MESSAGE_PAGE_URL = baseUrl + "/default/entry_post";
    public String new_post_text = "Hello Savva!";
    public String userId = "Savva Genchevskiy (101)";


    public SelenideElement postField = $(byId("post_new_post")),
                submitButton = $(byXpath("//*/input[@type='submit']")),
                idField = $(byId("post_user_id__row")).$(byClassName("w2p_fw"));


    public PostMessagePage openPage(){
        open(POST_MESSAGE_PAGE_URL);
        return this;
    }

    public PostTable createPost(String text){
        postField.setValue(text);
        submitButton.click();
        return new PostTable();
    }


}
