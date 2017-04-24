package com.FabrikaProject.Pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.Waiter;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


import java.util.HashMap;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class ProfilePage {

    public static WebDriver driver;
    public static Waiter waiter = new Waiter();

    private String cookieName = "session_id_test_1";


    HashMap<String, String> cookies = new HashMap<String, String>(){{
        put("profileCookieValue", "195.138.69.181-690f196f-8d52-456e-a47c-5260d2b2ee9b");
        put("testProfileCookieValue", "195.138.69.181-f793c268-5c70-4606-a206-aa0577f86fe2");
    }};

    public Cookie profileCookie = new Cookie.Builder(cookieName, cookies.get("profileCookieValue")).build();










    public static final String PROFILE_PAGE_URL = baseUrl + "default/user/profile";

    public SelenideElement deleteCheckBox = $(byId("delete_record")),
                    submitButton = $(byXpath("//*/input[@value='Submit']")),
                    firstNameField = $(byName("first_name"));

    public ProfilePage openPage(){
        open(PROFILE_PAGE_URL);
        return this;
    }


    public SuccessDeletingPage deleteProfile(){
        deleteCheckBox.click();
        switchTo().alert().accept();
        deleteCheckBox.shouldBe(Condition.selected);
        submitButton.click();
        return new SuccessDeletingPage();
    }






}
