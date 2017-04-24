package com.FabrikaProject.Pages.HomePage;

import com.FabrikaProject.Pages.*;
import com.FabrikaProject.Pages.ContactsPage.ContactsPage;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    public static final String HOME_PAGE_URL = baseUrl + "/default/index";

    public String logged_in_flash_message = "Welcome to Selenium course, Savva!" + "\n" + "×";
    public String not_logged_in_flash_message = "Welcome to Selenium course!" + "\n" + "×";


    public SelenideElement flash = $(byClassName("flash")),
            profileButton = $(byLinkText("Profile")),
            registerButton = $(byText("Register")),
            logoutButton = $(byLinkText("Logout")),
            loginButton = $(byText("Login")),
            aboutLink = $(byXpath("//*/a[@href='/test_1/default/about']")),
            termsLink = $(byXpath("//*/a[@href='/test_1/default/terms']")),
            contactsLink = $(byXpath("//*/a[@href='/test_1/default/contact']")),
            descriptionButton = $(byLinkText("Description"));
    public SelenideElement postMessageField = $("tbody tr#post_new_post__row td.w2p_fw");




    public ElementsCollection posts = $$(".web2py_htmltable table tbody tr");


    public HomePage openPage(){
        open(HOME_PAGE_URL);
        return this;
    }


    public ElementsCollection getPosts(){
        return posts;
    }

    public SelenideElement getPost(int  index){
        return $(".web2py_htmltable table tbody tr", index);
    }


    public HomePage deletePost(int index){
        getPost(index).$(byXpath("//td[3]/a[2]")).click();
        confirm();

        /*posts.last().$(byXpath("//td[1]")).shouldHave(Condition.text(text)).
                $(byXpath("//td[3]/a[2]/..")).click();*/
        /*posts.get(index).$(byXpath("//td[3]/a[2]")).click();
        confirm();*/
        return this;
    }

    public HomePage viewPost(int index){
        getPost(index).$(byXpath("//td[3]/a[1]")).click();
        return this;
    }


    public HomePage deleteLastPost(){
        posts.last().$(byXpath("//td[3]/a[2]")).click();
        confirm();
        return this;
    }

    public ProfilePage pressProfile(){
        profileButton.click();
        return new ProfilePage();
    }

    public AboutPage pressAbout(){
        aboutLink.click();
        return new AboutPage();
    }

    public TermsPage pressTerms(){
        termsLink.click();
        return new TermsPage();
    }

    public DescriptionPage pressDescripton(){
        descriptionButton.click();
        return new DescriptionPage();
    }

    public ContactsPage pressContats(){
        contactsLink.click();
        return new ContactsPage();
    }








}