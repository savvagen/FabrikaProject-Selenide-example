package com.FabrikaProject.Utilites;


import com.FabrikaProject.Pages.*;
import com.FabrikaProject.Pages.ContactsPage.ContactsPage;
import com.FabrikaProject.Pages.ContactsPage.ContactsTable;
import com.FabrikaProject.Pages.HomePage.HomePage;
import com.FabrikaProject.Pages.HomePage.PostTable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {


    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static HomePage homePage;
    public static PostMessagePage postPage;
    public static PostTable posts;
    public static RegistrationPage registrationPage;
    public static SuccessDeletingPage deletePage;
    public static AboutPage aboutPage;
    public static ContactsPage contactsPage;
    public static ContactsTable contactsTable;
    public static DescriptionPage descriptionPage;
    public static TermsPage termsPage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
        browser = "chrome";
        browserSize = "1366x768";
        baseUrl = "http://vlay.pythonanywhere.com/test_1";

        profilePage = new ProfilePage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        postPage = new PostMessagePage();
        posts = new PostTable();
        registrationPage = new RegistrationPage();
        deletePage = new SuccessDeletingPage();
        aboutPage = new AboutPage();
        contactsPage = new ContactsPage();
        contactsTable = new ContactsTable();
        descriptionPage = new DescriptionPage();
        termsPage = new TermsPage();
    }

    @AfterMethod
    public void tearDown(){
        if (homePage.logoutButton.is(visible)){
            homePage.logoutButton.shouldBe(visible).click();
            homePage.loginButton.shouldBe(visible);

        }

    }





}
