package com.FabrikaProject.Utilites;


import com.FabrikaProject.Pages.*;
import com.FabrikaProject.Pages.ContactsPage.ContactsPage;
import com.FabrikaProject.Pages.ContactsPage.ContactsTable;
import com.FabrikaProject.Pages.HomePage.HomePage;
import com.FabrikaProject.Pages.HomePage.PostTable;
import com.FabrikaProject.Utilites.Listeners.EventListener;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;





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
        Configuration.timeout = 10000;

        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.baseUrl = "http://vlay.pythonanywhere.com/test_1";
        WebDriverRunner.addListener(new EventListener());
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
        if (homePage.logoutButton.is(Condition.visible)){
            homePage.logoutButton.shouldBe(Condition.visible).click();
            homePage.loginButton.shouldBe(Condition.visible);
        }
    }





}
